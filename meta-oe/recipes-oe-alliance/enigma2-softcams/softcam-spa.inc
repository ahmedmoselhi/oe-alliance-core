# To create a softcam:
# - install binary to ${bindir}/
# - install other stuff wherever you need it
# - fill in (mandatory)
#   CAMNAME: Name of softcam, preferably matches ${bindir} name
# - fill in (optional)
#   CAMSTART: Command to start the softcam, default to ${bindir}/${CAMNAME}
#   CAMSTOP: Command to stop the softcam, default to killall ${CAMNAME}
# Instead of CAMSTART/CAMSTOP, you can create an init.d script called init.${CAMNAME}

LICENSE = "CLOSED"

FILES_${PN} = "${bindir} /usr/script"

# no docs, locales etc.
PACKAGES = "${PN}"

INSANE_SKIP_${PN} += "already-stripped"

CAMSTART ?= "exec start-stop-daemon -S -x ${bindir}/${CAMNAME}"
CAMSTOP  ?= "exec start-stop-daemon -K -R 2 -x ${bindir}/${CAMNAME}"

# Generate a simplistic standard init script
# (sorry for the sleep 1, but start-stop-daemon -R does not work as advertised)
do_compile_append () {
	if [ ! -f init.${CAMNAME} ]
	then
		cat > init.${CAMNAME} << EOF
#!/bin/sh
CAMD_ID=1796
####################
CAMNAME="${CAMNAME}"
INFOFILE_A=ecm.info
INFOFILE_B=ecm1.info
INFOFILE_C=ecm2.info
INFOFILE_D=ecm3.info
INFOFILE_E=ecm4.info
INFOFILE_F=ecm5.info
#Expert window
INFOFILE_LINES=1111111111000000
#Zapp after start
REZAPP=0
#####################
logger $0 $1
echo $0 $1
####################
case "\$1" in
start)
	ulimit -s 1024
	${CAMSTART}
	;;
stop)
	${CAMSTOP}
	;;
restart|reload)
	\$0 stop
	sleep 1
	\$0 start
	;;
version)
	echo "${PV}"
	;;
info)
	echo "${CAMNAME} ${PV}"
	;;
*)
	echo "Usage: \$0 start|stop|restart"
	exit 1
	;;
esac
exit 0
EOF

	fi
}

# Install routine, should be ok for most cams.
do_install_append () {
	install -d ${D}/usr/script
	install -m 755 ${S}/init.${CAMNAME} ${D}/usr/script/${CAMNAME}_cam.sh
}

