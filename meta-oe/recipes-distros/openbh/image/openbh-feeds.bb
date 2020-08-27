SUMMARY = "OpenBH Extras"
MAINTAINER = "OpenBH"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = "${PN}"

PV = "${IMAGE_VERSION}"
PR = "r5"

inherit packagegroup

RRECOMMENDS_${PN} = "\
    cdfs \
    curlftpfs \
    enigma2-display-skins \
    astra-sm \
    enigma2-plugin-extensions-dlnabrowser \
    enigma2-plugin-extensions-dlnaserver \
    minidlna \
    enigma2-plugin-systemplugins-serviceapp \
    enigma2-plugin-extensions-blurayplayer \
    enigma2-plugin-extensions-epgimport \
    enigma2-plugin-systemplugins-crossepg \
    enigma2-skins \
    enigma2-skins-openvix \
    oe-alliance-skins \
    enigma2-oe-alliance-plugins \
    enigma2-3rdparty-plugins \
    enigma2-plugins \
    enigma2-pliplugins \
    openssl-old \
    ${@bb.utils.contains("MACHINE_FEATURES", "skins1080", "hd-skins-meta", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "quadpip", "enigma2-plugin-systemplugins-quadpip", "", d)} \
    "
