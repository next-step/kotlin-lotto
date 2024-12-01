package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private const val CANNOT_CREATE_LOTTO_NUMBER_MESSAGE = "Lotto number must be between %s and %s."

        private val NUMBERS: Map<Int, LottoNumber> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith { LottoNumber(it) }

        fun from(number: Int): LottoNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException(
                CANNOT_CREATE_LOTTO_NUMBER_MESSAGE.format(MINIMUM_NUMBER, MAXIMUM_NUMBER),
            )
        }
    }

    override fun toString(): String {
        return number.toString()
    }
}
