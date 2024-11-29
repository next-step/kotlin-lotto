package lotto.domain

class LottoNumber(val number: Int) {
    init {
        require(number in Lotto.MINIMUM_NUMBER..Lotto.MAXIMUM_NUMBER) { "LottoNumber must be between 1 and 45" }
    }
}
