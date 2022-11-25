package lotto.domain

data class LottoMatch(
    val lottoRank: LottoRank,
    var matchTotalCount: Long = DEFAULT_MATCH_COUNT,
    var isBonusNumber: Boolean = DEFAULT_IS_BONUS_NUMBER
) {
    fun getProfit(): Long =
        matchTotalCount * lottoRank.reward

    companion object {
        const val DEFAULT_MATCH_COUNT = 0L
        private const val DEFAULT_IS_BONUS_NUMBER = false
    }
}
