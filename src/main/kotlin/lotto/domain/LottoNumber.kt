package lotto.domain

data class LottoNumber(val number: Int = 0) {
    init {
        require(number > 0)
        require(number in LOTTO_NUMBER_RANGE)
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
