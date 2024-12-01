package lotto.domain

@JvmInline
value class LottoNumber private constructor(private val number: Int) {
    init {
        validateInRange(number)
    }

    override fun toString(): String {
        return "$number"
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = IntRange(1, 45)
        val CACHED_LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.map { LottoNumber(it) }.toSet()

        fun getNumber(number: Int): LottoNumber {
            validateInRange(number)
            return CACHED_LOTTO_NUMBERS.first { it.number == number }
        }

        private fun validateInRange(number: Int) {
            require(number in LOTTO_NUMBER_RANGE) { "로또 번호는 1~45 내의 숫자여야 합니다." }
        }
    }
}
