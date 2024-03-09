require recipes-kernel/linux/linux-kernel-qcom_6.6.bb

SECTION = "RT kernel"
SUMMARY = "Linux Real time kernel for QCOM devices"
DESCRIPTION = "Recipe to build real time Linux kernel"

SRC_URI:append = "https://cdn.kernel.org/pub/linux/kernel/projects/rt/6.6/older/patch-6.6.14-rt21.patch.gz;md5sum=91969a704a73aa918c89d3027bdd3634 \
		 file://qcom_rt.cfg \
		 file://0001-arch-Kconfig-Add-RT-kernel-support.patch \
		 file://0001-printk-nbcon-move-locked-port-flag-to-struct-uart-port.patch \
		 "

S = "${WORKDIR}/git"
KERNEL_CONFIG_FRAGMENTS:append = " ${WORKDIR}/qcom_rt.cfg"
