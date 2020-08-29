SUMMARY = "Merge machine and distro options to create a enigma2 machine task/package"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"
PACKAGES = "${PN}"

PV = "1.0"
PR = "r4"

inherit packagegroup

DEPENDS = "enigma2-pliplugins egami-feeds"

RRECOMMENDS_${PN} = "\
    enigma2-skindefault \
    enigma2-plugin-skins-egmega32 \
    enigma2-plugin-skins-odreamyfhd \
    \
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
    enigma2-plugin-extensions-moviecut \
    enigma2-plugin-extensions-egamipermanentclock \
    enigma2-plugin-extensions-egaminews \
    enigma2-plugin-extensions-egamiclearmem \
    enigma2-plugin-extensions-epgimport \
    ${@bb.utils.contains("MACHINE_BRAND", "WeTeK", "", "enigma2-plugin-extensions-egamiboot", d)} \
    \
    enigma2-plugin-extensions-weatherplugin enigma2-plugin-systemplugins-weathercomponenthandler enigma2-plugin-skincomponents-weathercomponent \
    \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", "enigma2-plugin-extensions-openwebif-themes", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "enigma2-plugin-extensions-openwebif-webtv", "enigma2-plugin-extensions-openwebif-vxg", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "omb", "enigma2-plugin-extensions-openmultiboot", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "omb", "openmultiboot", "", d)} \    
    \
    enigma2-plugin-systemplugins-softwaremanager \
    enigma2-plugin-systemplugins-egamipluginspeedup \
    enigma2-plugin-systemplugins-videotune \
    enigma2-plugin-extensions-youtube \
    ${@bb.utils.contains("MACHINE_FEATURES", "videoenhancement", "", "enigma2-plugin-systemplugins-videoenhancement", d)} \
    \
"
