package lotto.domain.model.vo

/**
 * 로또 상금
 * */
@JvmInline
value class Prize(val value: Int) {
    init {
        require(value in MIN_PRIZE..MAX_PRIZE) {
            "상금은 ${MIN_PRIZE}원 ~ ${MAX_PRIZE}원의 가격만 들어와야 합니다."
        }
    }

    companion object {
        private const val MIN_PRIZE = 0
        private const val MAX_PRIZE = 2000000000

        fun valueOf(prize: Int) = Prize(prize)
    }
}
