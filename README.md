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

## Host Setup

Refer to https://github.com/quic-yocto/qcom-manifest/blob/qcom-linux-kirkstone/README.md setup the host environment.

## Download the Yocto Project BSP

Refer to https://github.com/quic-yocto/qcom-manifest/blob/qcom-linux-kirkstone/README.md Sync Yocto Project BSP.

## Build Realtime Linux Layer

```shell
export SHELL=/bin/bash
MACHINE=qcm6490 DISTRO=qcom-wayland source setup-environment
```

## Run below command to download  "meta-qcom-realtime" layer in [release] directory where you have just downloaded Yocto Project BSP.
```shell
git clone https://github.com/quic-yocto/meta-qcom-realtime -b kirkstone layers/meta-qcom-realtime
```

## Add meta-qcom-realtime layer in build-qcom-wayland/conf/bblayers.conf file
```shell
vi conf/bblayers.conf
```

```shell
EXTRALAYERS ?= " \
 ${WORKSPACE}/layers/meta-qcom-realtime \
"
```

## Run the following command to compile
```shell
bitbake qcom-multimedia-image
```
Image output path: ${RTLinux workspace}/build-qcom-wayland/tmp-glibc/deploy/images/qcm6490/qcom-multimedia-image.

## Flash image

To flash the generated build, see the [Flash software](https://docs.qualcomm.com/bundle/resource/topics/80-70014-251/flash_rb3_software_0.html)

# Reference

[Standard Yocto environment](https://docs.yoctoproject.org/4.0.13/brief-yoctoprojectqs/index.html)

[QCOM Linux Yocto BSP releases](https://github.com/quic-yocto/qcom-manifest/blob/qcom-linux-kirkstone/README.md)