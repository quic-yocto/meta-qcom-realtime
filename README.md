# Welcome to the Realtime Linux

In this documentation, you will learn:
- Introduction to meta-qcom-realtime layer
- How to sync and build the Realtime Linux Layer
- Flash image

Let's get started!

# Introduction
The Realtime layer provides recipes and configuration required to run linux kernel as a real time kernel.
The real time kernel runs with preemption fully enabled through a config, CONFIG_PREEMPT_RT=y
The layer supports linux-kernel-qcom-rt recipe that fetches and builds linux kernel for supported machine,
this layer appends to kernel, the upstream PREEMPT_RT patches based on kernel version and enables the realtime
configurations.

# How to sync and build the Realtime Linux Layer

## Host Setup and Download the Yocto Project BSP

Refer to [QCOM Linux Yocto BSP releases](https://github.com/qualcomm-linux/qcom-manifest/blob/qcom-linux-scarthgap/README.md) setup the host environment and download Yocto Project BSP.

```shell
mkdir [release]
cd [release]
repo init -u https://github.com/qualcomm-linux/qcom-manifest -b [branch name] -m [release manifest]
repo sync -c -j8
```
## Example
To download the qcom-6.6.142-QLI.1.9.1-Ver.1.0 release

```shell
repo init -u https://github.com/qualcomm-linux/qcom-manifest -b qcom-linux-scarthgap -m qcom-6.6.142-QLI.1.9.1-Ver.1.0.xml
repo sync
```

## Run below command to download "meta-qcom-realtime" layer in [release] directory where you have downloaded Yocto Project BSP.

```shell
cd [release]
git clone https://github.com/qualcomm-linux/meta-qcom-realtime -b [meta-qcom-realtime release tag] layers/meta-qcom-realtime
```
Note: Find the latest "meta-qcom-realtime" layer release tag names at https://github.com/qualcomm-linux/meta-qcom-realtime/tags

## Examples

To download the `qcom-6.6.142-QLI.1.9.1-Ver.1.0_realtime-linux-1.0` release tag
```shell
git clone https://github.com/qualcomm-linux/meta-qcom-realtime -b qcom-6.6.142-QLI.1.9.1-Ver.1.0_realtime-linux-1.0 layers/meta-qcom-realtime
```

## Build Realtime Linux Layer

```shell
export SHELL=/bin/bash
export EXTRALAYERS="meta-qcom-realtime"
MACHINE=qcs6490-rb3gen2-core-kit DISTRO=qcom-wayland source setup-environment
```

## Run the following command to compile and generate flashable image with Yocto Project BSP plus REALTIME LINUX layer
```shell
bitbake qcom-multimedia-image
```
Image output path: $[release]/build-qcom-wayland/tmp-glibc/deploy/images/qcm6490/qcom-multimedia-image.

## Flash the image

To flash the generated build, see the [Flash images](https://docs.qualcomm.com/bundle/publicresource/topics/80-70017-254/flash_images.html?vproduct=1601111740013072&latest=true)

# Reference

[Standard Yocto environment](https://docs.yoctoproject.org/5.0.15/brief-yoctoprojectqs/index.html)

[QCOM Linux Yocto BSP releases](https://github.com/qualcomm-linux/qcom-manifest/blob/qcom-linux-scarthgap/README.md)
