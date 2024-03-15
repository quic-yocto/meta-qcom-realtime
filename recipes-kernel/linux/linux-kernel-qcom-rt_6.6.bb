require recipes-kernel/linux/linux-kernel-qcom_6.6.bb

SECTION = "RT kernel"
SUMMARY = "Linux Real time kernel for QCOM devices"
DESCRIPTION = "Recipe to build real time Linux kernel"

SRC_URI:append = "https://cdn.kernel.org/pub/linux/kernel/projects/rt/6.6/older/patch-6.6.20-rt25.patch.gz;md5sum=f9e8d796d0c4e5fa770bfce95ab381ae \
		 file://qcom_rt.cfg \
		 file://0001-arch-Kconfig-Add-RT-kernel-support.patch \
		 "

S = "${WORKDIR}/git"
KERNEL_CONFIG_FRAGMENTS:append = " ${WORKDIR}/qcom_rt.cfg"
