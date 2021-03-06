SUMMARY = "Base packages require for image."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"

PV = "7.4"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " openspa-base-files \
    ca-certificates \
    flip \
    hddtemp \
    oe-alliance-base \
    openspa-bootlogo \
    openspa-enigma2 \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "openssh-sftp-server ", d)} \
    packagegroup-base-smbfs-client \
    python-imaging \
    python-service-identity \
    python-runpy python-gdata python-google-api-client python-httplib2 python-uritemplate python-youtube-dl python-oauth2client \
    rtmpdump \
    ${@bb.utils.contains("TUNE_FEATURES", "armv", "glibc-compat", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "dreamboxv1", "", "ofgwrite", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "iproute2 tar", d)} \
    ${@bb.utils.contains_any("FLASHSIZE", "64 96", "", "ntfs-3g unrar zip", d)} \
    openvpn-script \
    mhw2-files \
    "
