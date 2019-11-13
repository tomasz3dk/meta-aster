LICENSE = "CLOSED"

SRC_URI = "https://www.pjsip.org/release/${PV}/pjproject-${PV}.tar.bz2"
SRC_URI[md5sum] = "6487d54213f270d307eaa60efc9f56f3"
SRC_URI[sha256sum] = "503d0bd7f9f13dc1492ac9b71b761b1089851fbb608b9a13996edc3c42006f79"

DEPENDS = "alsa-lib openssl"

EXTRA_OECONF += "--enable-shared --disable-resample --disable-video \
    --disable-speex-aec --disable-l16-codec --disable-gsm-codec \
    --disable-g7221-codec --disable-speex-codec --disable-ilbc-codec --disable-sdl --disable-ffmpeg \
    --disable-v4l2 --disable-ssl --disable-libyuv --disable-libwebrtc"

inherit autotools-brokensep pkgconfig

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
