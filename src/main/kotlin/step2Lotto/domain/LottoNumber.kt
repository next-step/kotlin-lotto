package step2Lotto.domain

data class LottoNumber(private val _value: Int) {
    init {
        check(_value in MINIMUM_NUMBER..MAXIMUM_NUMBER)
    }

    val value: Int
        get() = _value

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        val NUMBERS = MINIMUM_NUMBER..MAXIMUM_NUMBER
    }
}
