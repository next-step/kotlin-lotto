package lotto.domain

data class LottoNumber private constructor(
    val number: Int
) {
    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
        private val NUMBERS = (MIN_VALUE..MAX_VALUE).associateWith(::LottoNumber)

        fun of(number: Int): LottoNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException()
        }
    }
}
