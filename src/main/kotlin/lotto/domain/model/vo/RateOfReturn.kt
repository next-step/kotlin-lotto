package lotto.domain.model.vo

/**
 * 로또 수익률
 * */
@JvmInline
value class RateOfReturn(val rateOfReturn: Double) {
    init {
        require(rateOfReturn >= MIN_RATE_OF_RETURN) {
            "수익률은 ${MIN_RATE_OF_RETURN}보다 낮을 수 없습니다."
        }
    }

    companion object {
        private const val MIN_RATE_OF_RETURN = 0.0

        fun valueOf(rateOfReturn: Double) = RateOfReturn(rateOfReturn)
    }
}
