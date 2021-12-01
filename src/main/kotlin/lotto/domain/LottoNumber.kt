package lotto.domain

class LottoNumber private constructor(private val value: Int) {
    override fun toString(): String {
        return "$value"
    }

    companion object {
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        private val RANGE = (MINIMUM_NUMBER..MAXIMUM_NUMBER)
        private val NUMBERS = mutableMapOf<Int, LottoNumber>()

        fun from(value: Int): LottoNumber {
            validateBoundary(value)
            return NUMBERS[value] ?: LottoNumber(value).also { NUMBERS[value] = it }
        }

        private fun validateBoundary(value: Int) {
            require(RANGE.contains(value)) {
                "로또 숫자는 1부터 45만 가능합니다."
            }
        }
    }
}
