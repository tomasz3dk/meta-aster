RDEPENDS_${PN}_append = " \
	qtremoteobjects-dev \
	qtremoteobjects-mkspecs \
	qtremoteobjects-qmlplugins \
	qtgamepad-dev \
	qtgamepad-mkspecs \
	qtgamepad-qmlplugins \
	qtknx-dev \
	qtknx-mkspecs \
	qtmqtt-dev \
	qtmqtt-mkspecs \
	qtnetworkauth-dev \
	qtnetworkauth-mkspecs \
	qtopcua-dev \
	qtopcua-mkspecs \
	qmqtt-dev \
	qmqtt-mkspecs \
"
RDEPENDS_${PN}_raspberrypi3_append = " \
	qtdatavis3d-dev \
	qtdatavis3d-mkspecs \
"
#RDEPENDS_${PN}_raspberrypi3_append = " \
#	qtwebengine-dev \
#	qtwebengine-mkspecs \
#	qtwebengine-qmlplugins \
#"

RDEPENDS_${PN}_remove = " \
	qtwebkit-dev \
"