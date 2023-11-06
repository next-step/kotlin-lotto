package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in (1..49)) {
            "numbers should be between 1 to 49: now is $number"
        }
    }
}
