package lotto.domain

data class LottoMatch(
    val lottoRank: LottoRank,
    val matchTotalCount: Long = DEFAULT_MATCH_COUNT
) {
    fun getProfit(): Long =
        matchTotalCount * lottoRank.reward

    companion object {
        const val DEFAULT_MATCH_COUNT = 0L
    }
}
