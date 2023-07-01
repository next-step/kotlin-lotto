package lotto.sixFortyFiveNumberLotto

fun SixFortyFiveLottoPurchases.merge(purchases: SixFortyFiveLottoPurchases) = SixFortyFiveLottoPurchases(
    listOf(
        *this.value.toTypedArray(),
        *purchases.value.toTypedArray(),
    ),
)

class SixFortyFiveLottoPurchases(val value: List<SixFortyFiveLottoPurchase>) {

    constructor(vararg purchase: SixFortyFiveLottoPurchase) : this(purchase.toList())

    fun getCount(): SixFortyFiveLottoCount {
        return SixFortyFiveLottoCount(value.size)
    }

    companion object {
        fun ofAutoFromManual(
            purchaseCount: SixFortyFiveLottoCount,
            manualLottoPurchases: SixFortyFiveLottoPurchases,
        ): SixFortyFiveLottoPurchases {
            val autoLottoCount = purchaseCount.value - manualLottoPurchases.value.size
            val autoLottoPurchaseList =
                (1..autoLottoCount).map { SixFortyFiveLottoPurchase.ofAuto(SixFortyFiveLotto.getNumbers()) }
            return SixFortyFiveLottoPurchases(autoLottoPurchaseList)
        }
    }
}
