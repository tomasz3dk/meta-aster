
SUMMARY = "InfluxDB cpp client library"
HOMEPAGE = "https://github.com/awegrzyn/influxdb-cxx"
MAINTAINER = "Tomasz Drążek <drazektomasz@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c3fd56453495159528e8956b754310be"

SRC_URI = "git://github.com/awegrzyn/influxdb-cxx.git;protocol=https"

PV = "0.5.0+git${SRCPV}"
SRCREV = "472a752f511817c63ade3b43892b92221804c0c1"

S = "${WORKDIR}/git"

FILES_${PN} = "\
	${libdir}/libInfluxDB.so \
"
FILES_${PN}-dev = "\
	${includedir} \
	${libdir}/cmake \
"

DEPENDS = "boost curl"

inherit cmake

EXTRA_OECMAKE += "-DINFLUXCXX_TESTING=OFF"

