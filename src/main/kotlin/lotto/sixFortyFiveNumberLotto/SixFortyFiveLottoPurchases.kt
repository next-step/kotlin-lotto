package lotto.sixFortyFiveNumberLotto

fun SixFortyFiveLottoPurchases.merge(purchases: SixFortyFiveLottoPurchases) = SixFortyFiveLottoPurchases(
    listOf(
        *this.value.toTypedArray(),
        *purchases.value.toTypedArray(),
    ),
)

class SixFortyFiveLottoPurchases(val value: List<SixFortyFiveLottoPurchase>) {

    constructor(vararg purchase: SixFortyFiveLottoPurchase) : this(purchase.toList())

    companion object {
        fun ofAutoFromManual(
            purchaseCount: Int,
            manualLottoPurchases: SixFortyFiveLottoPurchases,
        ): SixFortyFiveLottoPurchases {
            val autoLottoCount = purchaseCount - manualLottoPurchases.value.size
            val autoLottoPurchaseList =
                (1..autoLottoCount).map { SixFortyFiveLottoPurchase.ofAuto(SixFortyFiveLotto.getNumbers()) }
            return SixFortyFiveLottoPurchases(autoLottoPurchaseList)
        }
    }
}
