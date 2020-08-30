SUMMARY = "Base packages require for image."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"
PACKAGES = "${PN}"

PV = "1.0"
PR = "r1"

inherit packagegroup

RDEPENDS_${PN} = "\
	oe-alliance-base \
	\
	egami-enigma2 \
	egami-bootlogo \
	egami-version-info \
	egami-base-files \
	\
        ca-certificates \  
        curl \  
        dvbsnoop \
        hddtemp \
        inadyn-mt \
        libcrypto-compat-0.9.7 \
        mc \
        ntfs-3g \
        openvpn \
        python-imaging \
        python-service-identity \
        python-wifi \
        rtmpdump \
"

RRECOMMENDS_${PN} = "\
	streamripper \
	hdparm \
	minidlna \
	djmount \
"
