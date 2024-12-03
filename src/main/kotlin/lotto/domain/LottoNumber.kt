package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MINIMUM_NUMBER..MAXIMUM_NUMBER) {
            CANNOT_CREATE_LOTTO_NUMBER_MESSAGE.format(MINIMUM_NUMBER, MAXIMUM_NUMBER)
        }
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private const val CANNOT_CREATE_LOTTO_NUMBER_MESSAGE = "Lotto number must be between %s and %s."
    }
}
