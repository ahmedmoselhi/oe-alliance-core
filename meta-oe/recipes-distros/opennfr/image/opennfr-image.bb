SUMMARY = "OPENNFR Image"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "OPENNFR team"

require conf/license/license-gplv2.inc

PV = "${IMAGE_VERSION}"
PR = "${BUILD_VERSION}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

IMAGE_INSTALL = " \
    autofs \
    unjffs2 \
    wireless-tools \
    rt3070 \
    mt7601u \
    rt8188eu \
    rtl8192cu \
    early-configure \
    kernel-params \
    nfr4xmultiboot \
    opennfr-base \
    packagegroup-base-smbfs-client \
    packagegroup-base-smbfs-server \
    packagegroup-base-nfs \ 
    enigma2-locale-en \
    enigma2-locale-ar \
    enigma2-locale-ru \
"
export IMAGE_BASENAME = "opennfr-image"
IMAGE_LINGUAS = ""

IMAGE_FEATURES += "package-management"

INHIBIT_DEFAULT_DEPS = "1"

inherit image

do_package_index[nostamp] = "1"
do_package_index[depends] += "${PACKAGEINDEXDEPS}"

rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    # because we're so used to it
    ln -s opkg usr/bin/ipkg || true
    ln -s opkg-cl usr/bin/ipkg-cl || true
    ln -s libcrypto.so.1.0.2 usr/lib/libcrypto.so.0.9.8 || true
    
}

python do_package_index() {
    from oe.rootfs import generate_index_files
    generate_index_files(d)
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_postprocess; "
addtask do_package_index after do_rootfs before do_image_complete

