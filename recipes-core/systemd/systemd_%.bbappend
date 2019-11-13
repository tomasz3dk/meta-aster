FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
	 file://eth.network \
"

do_install_append() {
    install -d ${D}${systemd_unitdir}/network/
    install -m 0644 ${WORKDIR}/eth.network ${D}${systemd_unitdir}/network/
}