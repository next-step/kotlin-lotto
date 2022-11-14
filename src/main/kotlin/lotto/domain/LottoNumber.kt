package lotto.domain

private val LOTTO_RANGE = 1..45
data class LottoNumber(
    val value: Int
) {
    init {
        require(value in LOTTO_RANGE)
    }
}
