package lotto.domain

data class LottoStatistics(
    val totalMatchCount: Int,
    val rank: Rank,
) {
    fun getTotalPrizeMoney(): Int {
        return this.rank.prizeAmount * totalMatchCount
    }
}
