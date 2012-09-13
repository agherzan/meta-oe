DESCRIPTION = "Manage character and block device lockfiles."
HOMEPAGE = "http://anonscm.debian.org/gitweb/?p=lockdev/lockdev.git;a=summary"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8045f3b8f929c1cb29a1e3fd737b499"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/l/lockdev/lockdev_${PV}.orig.tar.gz"

SRC_URI[md5sum] = "64b9c1b87b125fc348e892e24625524a"
SRC_URI[sha256sum] = "ccae635d7ac3fdd50897eceb250872b3d9a191d298f213e7f0c836910d869f82"

S = "${WORKDIR}/lockdev-${PV}"

inherit autotools

EXTRA_OEMAKE = 'CC="${CC}" \
                LD="${LD}" \
                basedir="${D}" \
                incdir="${D}${includedir}" \
                libdir="${D}${libdir}" \
                mandir="${D}${mandir}"'

do_compile() {
    oe_runmake shared
}
