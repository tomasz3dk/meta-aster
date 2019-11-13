# meta-aster
Yocto layer for building custom images and sdks for [raspberrypi](https://raspberrypi.org) and [beaglebone](https://beagleboard.org) boards. 

## Dependencies
This layer depends on additional layers:
 - [poky](http://git.yoctoproject.org/cgit/cgit.cgi/poky)
 - [meta-openembedded](http://git.openembedded.org/meta-openembedded)
 - [meta-qt5](https://github.com/meta-qt5/meta-qt5)
 - [meta-raspberrypi](http://git.yoctoproject.org/cgit.cgi/meta-raspberrypi)



## Environment preparation
### General informations
Before starting building, make sure that all required tools are installed on your host machine. For more informations how to configure your machine visit [Yocto project page](https://yoctoproject.org)
### By ansible playbook
Inside `scripts/ansible` directory is [ansible](https://www.ansible.com/) playbook to clone all required layers inside specific directory on your host machine, and set example configuration files: `local.conf` and `bblayers.conf`

To setup environmet by ansible playbook run:

    $ ansbile-playbook scripts/ansible/prepare_environment.yml

By default it prepares environment in `~/yocto` directory for `raspberrypi3` board. If you want to change this you can pass additional variables to `prepare_environment.yml` playbook

Directory structure:

    . ~/yocto
    |
    +-- poky
    |   +-- [all layers directories]
    +-- [board]_[yocto release] (ex: raspberrypi3_zeus)
        +-- conf
            +-- bblayers.conf
            +-- local.conf

Available variables:

- board (machine for which image will be generated can be: raspberrypi3, raspberry or beaglebone-yocto)
- yocto_release (yocto release e.g: zeus, warrior... By default same as meta-aster layer)
- dir (directory where all layers will be cloned and machine specific directories will be created. By defult: `~/yocto`)

For example to create environment for `raspberrypi 1` board, `zeus` release inside `~/yocto_sdk` directory run:

    $ ansible-playbook -e "board=raspberrypi yocto_release=zeus dir=~/yocto_sdk" scripts/ansible/prepare_environment.yml

### Manual
According to yocto manual
- Clone all required layers inside some directory
- Clone meta-aster layer inside same directory
- Create build directory
- Configure `bblayers.conf` file with proper paths
- Configure `local.conf` file according to your need
- For configuration files examples form `examples` directory of this layer can be used

## Building image and sdk

Source environment script

    $ source ~/yocto/poky/oe-init-build-env ~/yocto/raspberrypi3_zeus

Building default image

    $ bitbake aster-image

Building sdk

    $ bitbake aster-image -c populate_sdk

```Note: All output files are located in default locations inside build directory```

## Additional informations
- By default building process is configured to use [icecream](https://github.com/icecc/icecream) distributed compilation to use more machines to speed up build process. If only one machine will be used comment `INHERIT += "icecc"` line in `local.conf` file from build directory.

- Images only have root user without password
