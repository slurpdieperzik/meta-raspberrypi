#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual and is used to compile and include a
# simple "Hello World!" C program in the Raspberry Pi build as an executable
# script.
#

SUMMARY = "Simple script that prints 'Hello World!'"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "glibc"

#SRC_URI = "file:///home/bruno/Programming/poky/meta-raspberrypi/recipes-hello_world/hello_world/hello_world_0.1/hello_world.c"
SRC_URI= "file://helloworld.c"

S = "${WORKDIR}"

do_compile() {
         ${CC} helloworld.c ${LDFLAGS} -o helloworld
}

do_install() {
         install -d ${D}${bindir}
         install -m 0755 helloworld ${D}${bindir}
}
