package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in (1..45)) {
            "numbers should be between 1 to 45: now is $number"
        }
    }
}
