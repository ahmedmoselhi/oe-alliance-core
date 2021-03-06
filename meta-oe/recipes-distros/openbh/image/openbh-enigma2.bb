SUMMARY = "OpenBH Enigma2"
MAINTAINER = "OpenBH"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"
PACKAGES = "${PN}"

PV = "${IMAGE_VERSION}"
PR = "r13"

inherit packagegroup

RCONFLICTS_${PN} = "enigma2-plugin-extensions-permanenttimeshift enigma2-plugin-systemplugins-skinselector"
RREPLACES_${PN} = "enigma2-plugin-extensions-permanenttimeshift enigma2-plugin-systemplugins-skinselector"

DEPENDS = "enigma2-pliplugins openbh-feeds"

RDEPENDS_${PN} = "\
    enigma2-skindefault \
    openbh-core \
    "

RRECOMMENDS_${PN} = " \
    enigma2-plugin-extensions-autotimer \
    enigma2-plugin-extensions-cutlisteditor \
    enigma2-plugin-extensions-epgimport \
    enigma2-plugin-extensions-epgrefresh \
    enigma2-plugin-extensions-epgsearch \
    enigma2-plugin-extensions-mediaplayer \
    enigma2-plugin-extensions-socketmmi \
    enigma2-plugin-systemplugins-crossepg \
    enigma2-plugin-systemplugins-wirelesslan \
    enigma2-plugin-systemplugins-networkbrowser \
    enigma2-plugin-systemplugins-networkwizard \
    enigma2-plugin-systemplugins-hotplug \
    enigma2-plugin-extensions-openwebif \
    enigma2-plugin-systemplugins-satfinder \
    ${@bb.utils.contains("MACHINE_FEATURES", "videoenhancement", "", "enigma2-plugin-systemplugins-videoenhancement", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-themes enigma2-plugin-extensions-openwebif-terminal", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "enigma2-plugin-extensions-openwebif-webtv", "enigma2-plugin-extensions-openwebif-vxg", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "enigma2-plugin-systemplugins-animationsetup" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "omb", "enigma2-plugin-extensions-openmultiboot", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "omb", "openmultiboot", "", d)} \
    ${@bb.utils.contains("TARGET_ARCH", "arm", "glibc-compat", "", d)} \
    tuxbox-links \
    tuxbox-common \
    mtd-utils \
    aio-grab \
    procps \
    parted \    
    enigma2-plugin-softcams-oscam-emu-obh \
    enigma2-plugin-softcams-ncam-obh \
    "

