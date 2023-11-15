package lotto.domain.model.vo

/**
 * 로또 가격
 * */
@JvmInline
value class Price(val price: Int) {
    init {
        require(price in MIN_PRICE..MAX_PRICE) {
            "로또 가격은 ${MIN_PRICE}~${MAX_PRICE}원 사이여야 합니다."
        }
        require(price % DEFAULT_PRICE == DEFAULT_REMAINDER) {
            "로또 가격은 ${MIN_PRICE}~${MAX_PRICE}원 사이여야 합니다."
        }
    }

    companion object {
        private const val DEFAULT_PRICE = 1000
        private const val DEFAULT_REMAINDER = 0
        private const val MIN_PRICE = 1000
        private const val MAX_PRICE = 3000

        fun valueOf(prize: Int = DEFAULT_PRICE) = Price(prize)
    }
}
