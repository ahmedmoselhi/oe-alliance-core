SUMMARY = "OpenViX Enigma2"
MAINTAINER = "OpenViX"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"
PACKAGES = "${PN}"

PV = "${IMAGE_VERSION}"
PR = "r21"

inherit packagegroup

RCONFLICTS_${PN} = "enigma2-plugin-extensions-permanenttimeshift enigma2-plugin-systemplugins-skinselector"
RREPLACES_${PN} = "enigma2-plugin-extensions-permanenttimeshift enigma2-plugin-systemplugins-skinselector"

DEPENDS = "openvix-feeds"

RDEPENDS_${PN} = "\
    enigma2-skindefault \
    openvix-core \
    "

RRECOMMENDS_${PN} = "\
    enigma2-plugin-extensions-autotimer \
    enigma2-plugin-extensions-epgimport \
    enigma2-plugin-extensions-epgsearch \
    enigma2-plugin-extensions-epgrefresh \
    enigma2-plugin-extensions-imdb \
    enigma2-plugin-skins-openvix-magic-fhd \
    enigma2-plugin-skins-openvix-simple-ten-eighty \
    enigma2-plugin-skins-openvix-vix-day-hd \
    enigma2-plugin-skins-openvix-youvix-blue \
    enigma2-plugin-systemplugins-xmlupdate \
    enigma2-plugin-systemplugins-wirelesslan \
    enigma2-plugin-systemplugins-hotplug \
    enigma2-plugin-systemplugins-hdmicec \
    enigma2-plugin-systemplugins-satfinder \
    enigma2-plugin-systemplugins-osdpositionsetup \    
    enigma2-plugin-extensions-mediaplayer \
    enigma2-plugin-extensions-pictureplayer \
    enigma2-plugin-extensions-mediascanner \
    tuxbox-links \
    tuxbox-common \
    mtd-utils \
    aio-grab \
    procps \
    parted \    
    enigma2-plugin-softcams-oscam-emu-openvix \
    enigma2-plugin-softcams-ncam-openvix \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-themes enigma2-plugin-extensions-openwebif-terminal", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "enigma2-plugin-extensions-openwebif-webtv", "enigma2-plugin-extensions-openwebif-vxg", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "videoenhancement", "", "enigma2-plugin-systemplugins-videoenhancement", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "enigma2-plugin-systemplugins-animationsetup" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "osdanimation", "enigma2-plugin-systemplugins-animationsetup" , "", d)} \
    "

RRECOMMENDS_${PN}_append_et8500 = " enigma2-plugin-extensions-yahooweather"
RRECOMMENDS_${PN}_append_tmnanoseplus = " enigma2-plugin-systemplugins-tempfancontrol"
RRECOMMENDS_${PN}_append_tmnanosem2 = " enigma2-plugin-systemplugins-tempfancontrol"
RRECOMMENDS_${PN}_append_tmnanosem2plus = " enigma2-plugin-systemplugins-tempfancontrol"
RRECOMMENDS_${PN}_append_tmtwin4k = " enigma2-plugin-systemplugins-tempfancontrol"
