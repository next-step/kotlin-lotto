package lotto.model

data class LottoNumber(val value: Int) {
    init {
        require(value in 1..46)
    }
}
