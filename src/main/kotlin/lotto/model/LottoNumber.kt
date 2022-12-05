package lotto.model

class LottoNumber(val value: Int) {
    init {
        require(value in 1..46)
    }
}
