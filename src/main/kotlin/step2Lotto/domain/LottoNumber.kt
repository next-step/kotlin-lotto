package step2Lotto.domain

data class LottoNumber(val value: Int) {
    init {
        check(value in MINIMUM_NUMBER..MAXIMUM_NUMBER)
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        val NUMBERS = MINIMUM_NUMBER..MAXIMUM_NUMBER
    }
}
