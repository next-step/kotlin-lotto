package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        validateRangeOfNumber(value)
    }

    private fun validateRangeOfNumber(number: Int) {
        require(number in LOTTO_NUMBER_RANGE) { "로또 번호는 ${LOTTO_NUMBER_RANGE}이어야 합니다." }
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = (1..45)
        private val ALL_LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.map { LottoNumber(it) }

        fun all(): List<LottoNumber> {
            return ALL_LOTTO_NUMBERS
        }
    }
}
