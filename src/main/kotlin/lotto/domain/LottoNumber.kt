package lotto.domain

data class LottoNumber(
    val value: Int
) {
    init {
        require(value in 1..45)
    }
}
