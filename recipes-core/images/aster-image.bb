SUMMARY = "A console development image"
HOMEPAGE = "http://astertom.pl"
LICENSE = "MIT"

IMAGE_FEATURES += " package-management"
IMAGE_LINGUAS = "pl-pl"

inherit core-image
inherit populate_sdk_qt5

ADD_EXTRA_SERVICES ?= "1"

CORE_OS = " \
    kernel-modules \
    openssh \
    openssh-keygen \
    openssh-sftp-server \
    tzdata \
    alsa-utils \
    alsa-plugins \
    packagegroup-core-full-cmdline \
"

DEV_SDK = " \
    gdbserver \
"
EXTRA_TOOLS = " \
    bzip2 \
    devmem2 \
    dosfstools \
    fbset \
    findutils \
    i2c-tools \
    nano \
    mc \
    procps \
    sysfsutils \
    unzip \
    util-linux \
    zip \
    usbutils \
    htop \
"
NETWORK_TOOLS = " \
    ntp \
    ntp-tickadj \
    tcpdump \
    wget \
    netcat \
    iperf3 \
    iproute2 \
    iptables \
    ethtool \
    tcpdump \
    dbus \
"

EXTRA_SERVICES = " \
    bluez5 \
    neard \
    canutils \
    mosquitto \
    vsftpd \
    openldap \
    krb5 \
"

EXTRA_LIBS = " \
    libftdi \
    zlib \
    icu \
    libsqlite3 \
    libusb1 \
    qmqtt \
    libgpiod \
    prometheus-cpp \
"
FONTS = " \
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
    freetype \
    packagegroup-fonts-truetype \
"
QT_PKGS = " \
    qtbase \
    qtbase-plugins \
    qttranslations \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-qmlplugins \
    qtconnectivity \
    qtimageformats \
    qtlocation \
    qtlocation-plugins \
    qtmultimedia \
    qtmultimedia-plugins \
    qtscript \
    qtsensors \
    qtsensors-plugins \
    qtsvg \
    qtsvg-plugins \
    qtsystems \
    qtwebsockets \
    qtwebsockets-plugins \
    qtwebsockets-qmlplugins \
    qtwebchannel \
    qtxmlpatterns \
    qtserialbus \
    qtquickcontrols2 \
    qtquickcontrols \
    qtcharts \
    qtdatavis3d \
    qtknx \
    qtmqtt \
    quazip \
    qtserialport \
    qtremoteobjects \
    qtgamepad \
    qtnetworkauth \
    qtopcua \
    qtwebglplugin \
    qtscxml \
"

QT_WEBENGINE = " \
    qtwebengine \
    qtwebengine-qmlplugins \
"
QT_EXTRAS = " \
    qt3d \
    qt3d-qmlplugins \
    qtgraphicaleffects \
"
GST_PKGS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ugly \
    gstreamer1.0-libav \
    gstreamer1.0-rtsp-server \
"
GST_RPI = " \
    gstreamer1.0-omx \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_SDK} \
    ${EXTRA_TOOLS} \
    ${NETWORK_TOOLS} \
    ${FONTS} \
    ${QT_PKGS} \
    ${EXTRA_LIBS} \
    ${GST_PKGS} \
    ${@bb.utils.contains('MACHINE', 'raspberrypi', '${GST_RPI}', '', d)} \
    ${@bb.utils.contains('MACHINE', 'raspberrypi3', '${QT_WEBENGINE} ${GST_RPI}', '', d)} \
    ${@bb.utils.contains('MACHINE', 'raspberrypi2', '${QT_WEBENGINE} ${GST_RPI}', '', d)} \
    ${@bb.utils.contains('MACHINE', 'raspberrypi3', '${QT_EXTRAS}', '', d)} \
    ${@bb.utils.contains('ADD_EXTRA_SERVICES', '1', '${EXTRA_SERVICES}', '', d)} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/Europe/Warsaw ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
"

export IMAGE_BASENAME = "aster-image"
