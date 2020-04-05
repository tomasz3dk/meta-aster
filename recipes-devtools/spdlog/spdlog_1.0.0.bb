SUMMARY = "Spdlog library"
DESCRIPTION = "Spdlog is very fast, header only, C++ logging library."
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6e5242b8f24d08c5e948675102937cc9 \
                    file://include/spdlog/fmt/bundled/LICENSE.rst;md5=c2e38bc8629eac247a73b65c1548b2f0 \
                    file://tests/catch.license;md5=2c7a3fa82e66676005cd4ee2608fd7d2"

SRC_URI = "git://github.com/gabime/spdlog.git;protocol=https;branch=v1.x"

SRCREV = "caff7296b162d97e44d6a1cc039adf689cfc02b3"

S = "${WORKDIR}/git"

ALLOW_EMPTY_${PN} = "1"

inherit cmake

FILES_${PN}-dev += " \
	/usr/lib/cmake/spdlog \
"
