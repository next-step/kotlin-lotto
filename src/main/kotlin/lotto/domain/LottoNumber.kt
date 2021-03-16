package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER)
    }

    override fun toString(): String {
        return number.toString()
    }
    companion object {
        const val LOTTO_MINIMUM_NUMBER = 1
        const val LOTTO_MAXIMUM_NUMBER = 45
    }
}
