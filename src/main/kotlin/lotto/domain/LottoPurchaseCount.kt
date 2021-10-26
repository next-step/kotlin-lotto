package lotto.domain

@JvmInline
value class LottoPurchaseCount private constructor(val value: Int) {

    companion object {
        private const val LOTTO_PRICE = 1_000

        fun from(purchaseAmount: LottoPurchaseAmount): LottoPurchaseCount {
            return LottoPurchaseCount(purchaseAmount.value!! / LOTTO_PRICE)
        }
    }
}
