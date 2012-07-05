DESCRIPTION = "Linpack benchmark, calculates FLOPS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "http://www.netlib.org/benchmark/linpackc.new \
			"

SRC_URI[md5sum] = "1c5d0b6a31264685d2e651c920e3cdf4"
SRC_URI[sha256sum] = "a63f2ec86512959f1fd926bfafb85905b2d7b7402942ffae3af374d48745e97e"

S = "${WORKDIR}"

do_compile() {
	# gcc can compile only .c
	cp linpackc.new linpack.c
	${CC} -O -o linpack linpack.c -lm
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 linpack ${D}${bindir}
}
