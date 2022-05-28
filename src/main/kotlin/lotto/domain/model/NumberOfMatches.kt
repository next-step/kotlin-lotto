package lotto.domain.model

@JvmInline
value class NumberOfMatches(val value: Int) {
    fun isWin(): Boolean = value in winNumberRange

    companion object {
        private const val MIN_MATCH_NUMBER = 3
        private const val MAX_MATCH_NUMBER = Lotto.LOTTO_NUMBER_COUNT

        val winNumberRange = (MIN_MATCH_NUMBER..MAX_MATCH_NUMBER)
    }
}
