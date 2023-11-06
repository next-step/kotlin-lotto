package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) {
            "로또 숫자는 1부터 45사이의 숫자여야 합니다."
        }
    }
}
