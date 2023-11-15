package lotto.domain.model.vo

/**
 * 구매 가격
 * */
@JvmInline
value class BuyPrice(val buyPrice: Int) {

    init {
        require(buyPrice > MIN_PRICE) {
            "구매 가격은 ${MIN_PRICE}보다 높아야 합니다."
        }
        require(buyPrice % DEFAULT_BUY_PRICE == DEFAULT_REMAINDER) {
            "구매 가격은 ${DEFAULT_REMAINDER}으로 나누어 떨어져야 합니다."
        }
    }

    companion object {
        private const val DEFAULT_BUY_PRICE = 1000
        private const val DEFAULT_REMAINDER = 0
        private const val MIN_PRICE = 0

        /**
         * 구매 가격 객체 생성
         * */
        fun valueOf(buyPrice: String = DEFAULT_BUY_PRICE.toString()): BuyPrice {
            require(buyPrice.isNotBlank() && buyPrice.toIntOrNull() != null) {
                "구매 가격은 숫자만 입력 가능합니다."
            }
            return BuyPrice(buyPrice.toInt())
        }
    }
}
