package lotto.domain

class LottoNumber private constructor(
    private val value: Int,
) {
    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber = NUMBERS[value] ?: throw IllegalArgumentException()
    }

    override fun toString(): String = "$value"
}
