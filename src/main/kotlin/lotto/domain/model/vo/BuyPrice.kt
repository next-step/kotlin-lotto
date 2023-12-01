package lotto.domain.model.vo

/**
 * 구매 가격
 * */
@JvmInline
value class BuyPrice(val value: Int) {
    init {
        require(value > MIN_PRICE) {
            "구매 가격은 ${MIN_PRICE}보다 높아야 합니다."
        }
        require(value % DEFAULT_BUY_PRICE == DEFAULT_REMAINDER) {
            "구매 가격은 ${DEFAULT_REMAINDER}으로 나누어 떨어져야 합니다."
        }
    }

    fun toDouble(): Double = value.toDouble()

    companion object {
        private const val DEFAULT_BUY_PRICE = 1000
        private const val DEFAULT_REMAINDER = 0
        private const val MIN_PRICE = 0

        /**
         * 구매 가격 객체 생성
         * */
        fun valueOf(buyPrice: Int = DEFAULT_BUY_PRICE): BuyPrice = BuyPrice(buyPrice)
    }
}
