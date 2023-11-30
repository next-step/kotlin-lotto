package lotto.domain.model.vo

/**
 * 로또 가격
 * */
@JvmInline
value class Price(val value: Int) {
    init {
        require(value in MIN_PRICE..MAX_PRICE) {
            "로또 가격은 ${MIN_PRICE}~${MAX_PRICE}원 사이여야 합니다."
        }
        require(value % DEFAULT_PRICE == DEFAULT_REMAINDER) {
            "로또 가격을 ${DEFAULT_PRICE}으로 나누었을 때 나머지가 ${DEFAULT_REMAINDER}원이 나와야 합니다."
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
