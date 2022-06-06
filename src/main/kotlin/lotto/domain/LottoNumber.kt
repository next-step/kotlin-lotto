package lotto.domain

class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_RANGE)
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
