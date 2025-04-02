package lotto

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { ERROR_RANGE }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val ERROR_RANGE = "Lotto number should be in between 1 and 45"
        private const val ERROR_VALUE = "Lotto number should be in between 1 and 45"
        private val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER).associateWith { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            return LOTTO_NUMBERS[value] ?: throw IllegalArgumentException(ERROR_VALUE)
        }

        fun all(): List<LottoNumber> {
            return LOTTO_NUMBERS.values.toList()
        }
    }
}
