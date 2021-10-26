package lotto.domain

@JvmInline
value class LottoPurchaseAmount private constructor(val value: Int?) {

    init {
        require(value != null && value in MINIMUM_LOTTO_PURCHASE_AMOUNT..MAXIMUM_LOTTO_PURCHASE_AMOUNT) { WRONG_LOTTO_PURCHASE_AMOUNT_MESSAGE }
    }

    companion object {
        private const val MINIMUM_LOTTO_PURCHASE_AMOUNT = 1_000
        private const val MAXIMUM_LOTTO_PURCHASE_AMOUNT = 100_000
        private const val WRONG_LOTTO_PURCHASE_AMOUNT_MESSAGE =
            "잘못된 로또 구입 금액입니다.(${MINIMUM_LOTTO_PURCHASE_AMOUNT}원)~(${MAXIMUM_LOTTO_PURCHASE_AMOUNT}원 입력)"

        fun from(input: String): LottoPurchaseAmount {
            return LottoPurchaseAmount(input.toIntOrNull())
        }
    }
}
