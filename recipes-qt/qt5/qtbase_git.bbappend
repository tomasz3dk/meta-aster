PACKAGECONFIG_raspberrypi_append = " accessibility eglfs fontconfig gles2 linuxfb dbus freetype glib release cups sql-sqlite sql-mysql evdev udev openssl icu zlib libpng jpeg gif harfbuzz widgets libs qtquickcompiler"
PACKAGECONFIG_raspberrypi3_append = " accessibility eglfs fontconfig gles2 linuxfb dbus freetype glib release cups sql-sqlite sql-mysql evdev udev openssl icu zlib libpng jpeg gif harfbuzz widgets libs qtquickcompiler"
PACKAGECONFIG_beaglebone-yocto_append = " no-opengl accessibility fontconfig linuxfb tslib dbus freetype glib release cups sql-sqlite sql-mysql evdev udev openssl icu zlib libpng jpeg gif harfbuzz widgets libs qtquickcompiler"

PACKAGECONFIG_remove = "examples tests"