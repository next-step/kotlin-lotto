package lotto.domain

data class Lotto(val numbers: List<LottoNumber>) {
    override fun toString(): String = numbers.joinToString(", ", "[", "]")

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_WINNING_MIN_COUNT = 3
    }
}
