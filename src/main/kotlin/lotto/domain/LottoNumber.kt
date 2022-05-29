package lotto.domain

data class LottoNumber(val number: Int) {

    init {
        require(number in RANGE_OF_LOTTO_NUMBER)
    }

    override fun toString(): String = number.toString()

    companion object {
        private const val MIN_RANGE_OF_NUMBER = 1
        private const val MAX_RANGE_OF_NUMBER = 45
        val RANGE_OF_LOTTO_NUMBER = MIN_RANGE_OF_NUMBER..MAX_RANGE_OF_NUMBER
    }
}
