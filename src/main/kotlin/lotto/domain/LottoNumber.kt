package lotto.domain

@JvmInline
value class LottoNumber private constructor(private val value: Int) {
    override fun toString(): String {
        return "$value"
    }

    companion object {
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        private val RANGE = (MINIMUM_NUMBER..MAXIMUM_NUMBER)
        private val numbers = mutableMapOf<Int, LottoNumber>()

        fun from(value: Int): LottoNumber {
            validateBoundary(value)
            return numbers[value] ?: LottoNumber(value).also { numbers[value] = it }
        }

        private fun validateBoundary(value: Int) {
            require(value in RANGE) {
                "로또 숫자는 1부터 45만 가능합니다."
            }
        }
    }
}
