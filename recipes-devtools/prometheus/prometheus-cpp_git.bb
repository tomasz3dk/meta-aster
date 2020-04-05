SUMMARY = "Prometheus cpp client library"
HOMEPAGE = "https://github.com/jupp0r/prometheus-cpp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=070140aa9bfe3450ae697487bc9eb15d"
MAINTAINER = "Tomasz Drążek <drazektomasz@gmail.com>"
SRC_URI = "git://github.com/jupp0r/prometheus-cpp.git;protocol=https"


PV = "1.0.0+${SRCPV}"
SRCREV = "d83dd68e496e024ae0f1f0c19ac2ab0d27330330"

S = "${WORKDIR}/git"

DEPENDS = "zlib curl civetweb"
RDEPENDS_${PN} = "zlib curl civetweb"

FILES_${PN} = "${libdir}/*.so"
FILES_${PN}-dev = "${includedir} ${libdir}/cmake/"

inherit cmake

EXTRA_OECMAKE = "-DENABLE_TESTING=OFF -DBUILD_SHARED_LIBS=ON -DUSE_THIRDPARTY_LIBRARIES=OFF"

