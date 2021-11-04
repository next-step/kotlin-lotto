package lotto.domain

@JvmInline
value class LottoPurchaseCount(val value: Int) {
    operator fun compareTo(count: LottoPurchaseCount): Int {
        return this.value.compareTo(count.value)
    }

    init {
        require(value >= 0) { WRONG_LOTTO_PURCHASE_COUNT_ENTERED_MESSAGE }
    }

    companion object {
        private const val WRONG_LOTTO_PURCHASE_COUNT_ENTERED_MESSAGE = "잘못된 로또 개수입니다."
        private const val LOTTO_PRICE = 1_000

        fun from(input: String): LottoPurchaseCount {
            val count = input.toIntOrNull()
            require(count != null) { WRONG_LOTTO_PURCHASE_COUNT_ENTERED_MESSAGE }
            return LottoPurchaseCount(count)
        }

        fun from(purchaseAmount: LottoPurchaseAmount): LottoPurchaseCount {
            return LottoPurchaseCount(purchaseAmount.value!! / LOTTO_PRICE)
        }
    }
}
