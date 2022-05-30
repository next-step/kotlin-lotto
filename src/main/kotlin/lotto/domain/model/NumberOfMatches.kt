package lotto.domain.model

@JvmInline
value class NumberOfMatches(val value: Int) {
    fun isWin(): Boolean = value in WIN_NUMBER_RANGE

    companion object {
        private const val MIN_MATCH_NUMBER = 3
        private const val MAX_MATCH_NUMBER = Lotto.LOTTO_NUMBER_COUNT

        val WIN_NUMBER_RANGE = (MIN_MATCH_NUMBER..MAX_MATCH_NUMBER)
    }
}
