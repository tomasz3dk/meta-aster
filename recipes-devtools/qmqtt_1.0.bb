SUMMARY = "MQTT library for Qt from emqtt"
HOMEPAGE = "https://github.com/emqtt/qmqtt"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62ddc846179e908dc0c8efec4a42ef20 \
                    file://tests/gtest/gtest/googletest/googlemock/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://tests/gtest/gtest/googletest/googlemock/scripts/generator/LICENSE;md5=2c0b90db7465231447cf2dd2e8163333 \
                    file://tests/gtest/gtest/googletest/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

SRC_URI = "git://github.com/emqtt/qmqtt.git;protocol=https"
SRCREV = "508b7145adae6fe88e9b18318ef144d5367fa20d"

DEPENDS += "qtbase qtwebsockets openssl"

S = "${WORKDIR}/git"

PACKAGES += "${PN}-mkspecs \
	${PN}-examples \
"

FILES_${PN}-mkspecs += "/usr/lib/mkspecs \
	/usr/lib/libqmqtt.prl \
	/usr/lib/mkspecs/modules \
"

FILES_${PN}-examples += "/usr/share/examples/qmqtt \
"

inherit qmake5

EXTRA_QMAKEVARS_PRE = " CONFIG+=NO_UNIT_TESTS"
