package lotto.domain

data class LottoStatistics(
    val lottoMatchCount: Int,
    val rank: Rank,
) {
    fun getTotalPrizeMoney(): Int {
        return this.rank.prizeAmount * lottoMatchCount
    }
}
