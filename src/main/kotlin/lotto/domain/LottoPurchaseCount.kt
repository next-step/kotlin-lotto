package lotto.domain

@JvmInline
value class LottoPurchaseCount private constructor(val value: Int) {

    companion object {
        private const val LOTTO_PRICE = 1_000

        fun from(purchaseAmount: Int): LottoPurchaseCount {
            return LottoPurchaseCount(purchaseAmount / LOTTO_PRICE)
        }
    }
}
