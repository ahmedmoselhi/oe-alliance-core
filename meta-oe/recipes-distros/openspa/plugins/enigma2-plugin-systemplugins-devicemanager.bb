DESCRIPTION = "Device manager for storage devices (format/change partitions and type/fast & fixed mount and umount)"
HOMEPAGE = "https://github.com/Dima73/enigma2-plugin-systemplugins-devicemanager"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README.md;md5=fa931694f4579578b39587f7ca837042"
SRC_URI = "git://github.com/ahmedmoselhi/enigma2-plugin-systemplugins-devicemanager.git"
S = "${WORKDIR}/git"

RRECOMMENDS_${PN} = "e2fsprogs-e2fsck e2fsprogs-mke2fs ntfsprogs hddtemp dosfstools e2fsprogs util-linux-sfdisk exfat-utils"

inherit gitpkgv

SRCREV = "${AUTOREV}"
PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

inherit distutils-openplugins

