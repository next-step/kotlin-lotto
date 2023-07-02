package lotto.sixFortyFiveNumberLotto.purchase

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoCount

fun SixFortyFiveLottoPurchases.merge(purchases: SixFortyFiveLottoPurchases) = SixFortyFiveLottoPurchases(
    listOf(
        *this.value.toTypedArray(),
        *purchases.value.toTypedArray(),
    ),
)

@JvmInline
value class SixFortyFiveLottoPurchases(val value: List<SixFortyFiveLottoPurchase>) {

    constructor(vararg purchase: SixFortyFiveLottoPurchase) : this(purchase.toList())

    companion object {
        fun ofAuto(count: SixFortyFiveLottoCount): SixFortyFiveLottoPurchases {
            return SixFortyFiveLottoPurchases((1..count.value).map { SixFortyFiveAutoLottoPurchase.of() })
        }
    }
}
