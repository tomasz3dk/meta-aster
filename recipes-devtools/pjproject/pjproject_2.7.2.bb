# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   third_party/speex/COPYING
#   third_party/threademulation/Microsoft Permissive License.txt
#   third_party/srtp/LICENSE
#   third_party/webrtc/LICENSE_THIRD_PARTY
#   third_party/webrtc/LICENSE
#   third_party/yuv/LICENSE_THIRD_PARTY
#   third_party/yuv/LICENSE
#   third_party/gsm/COPYRIGHT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
#                   file://third_party/speex/COPYING;md5=314649d8ba9dd7045dfb6683f298d0a8 \
#                   file://third_party/threademulation/Microsoft Permissive License.txt;md5=f58ba63af38dd6d4a8b008b0410ef54e \
#                   file://third_party/srtp/LICENSE;md5=2909fcf6f09ffff8430463d91c08c4e1 \
#                   file://third_party/webrtc/LICENSE_THIRD_PARTY;md5=ed03aeb01a1467f622f339fe130329b1 \
#                   file://third_party/webrtc/LICENSE;md5=ad296492125bc71530d06234d9bfebe0 \
#                   file://third_party/resample/COPYING;md5=8eff39a0f700f3566b976ca404e879fa \
#                   file://third_party/yuv/LICENSE_THIRD_PARTY;md5=66e9aa6de3f98711c6d12d09f6c31445 \
#                   file://third_party/yuv/LICENSE;md5=464282cfb405b005b9637f11103a7325 \
#                   file://third_party/gsm/COPYRIGHT;md5=97e265fa1fd10a668bd99c4945fb9200"

SRC_URI = "http://www.pjsip.org/release/${PV}/pjproject-${PV}.tar.bz2"
SRC_URI[md5sum] = "fa3f0bc098c4bff48ddd92db1c016a7a"
SRC_URI[sha256sum] = "9c2c828abab7626edf18e04b041ef274bfaa86f99adf2c25ff56f1509e813772"

# NOTE: some of these dependencies may be optional, check the Makefile and/or upstream documentation
DEPENDS = "alsa-lib openssl"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.
EXTRA_OECONF += "--disable-libwebrtc --enable-shared --disable-l16-codec --disable-gsm-codec --disable-resample --disable-libyuv \
	--disable-speex-aec --disable-ilbc-codec --disable-g7221-codec --disable-speex-codec"
inherit autotools-brokensep pkgconfig
#INSANE_SKIP_${PN}-dev = "ldflags"
do_configure_prepend() {
	export LD="${CXX}"
} 

do_install_append() {
    # remove the absolute path to the host's include dir
    sed -i 's:\-I/usr/include::' ${D}/usr/lib/pkgconfig/libpjproject.pc
    # remove the fdebug-prefix-map options
    sed -i 's:\-fdebug-prefix-map[a-zA-Z0-9\._\/=\-]*::g' ${D}/usr/lib/pkgconfig/libpjproject.pc
    chown -R root:root ${D}/usr/lib/libpj*
    chown -R root:root ${D}/usr/lib/libsrtp*
}

TARGET_CFLAGS += "-DPJ_AUTOCONF=1"
TARGET_CXXFLAGS += "-DPJ_AUTOCONF=1"
