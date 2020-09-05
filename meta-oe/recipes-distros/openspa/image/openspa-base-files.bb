SUMMARY = "EGAMI base files"
LICENSE = "GPL2"
require conf/license/license-gplv2.inc
PACKAGE_ARCH := "${MACHINE_ARCH}"

DEPENDS = " "
RDEPENDS_${PN} = " "

PR = "r1"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/ahmedmoselhi/openspa-base-files.git"

FILES_${PN} = "/bin /etc /scripts /media /usr"

INHIBIT_PACKAGE_STRIP = "1"

ALLOW_EMPTY_${PN} = "1"

S="${WORKDIR}/git/files"

do_install() {
	install -d ${D}/etc
	cp -a ${S}/etc/* ${D}/etc/

	install -d ${D}/media
	mkdir -p ${D}/media/card
	mkdir -p ${D}/media/cf
	mkdir -p ${D}/media/hdd
	mkdir -p ${D}/media/net
	mkdir -p ${D}/media/upnp
	mkdir -p ${D}/media/usb
	mkdir -p ${D}/media/usb1
	mkdir -p ${D}/media/usb2
	mkdir -p ${D}/media/usb3

	install -d ${D}/usr
	cp -a ${S}/usr/* ${D}/usr/
}
