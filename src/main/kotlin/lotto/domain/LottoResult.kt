package lotto.domain

data class LottoResult(
    val totalCount: Int,
    val rank: Rank,
) {
    fun getTotalPrizeMoney(): Int {
        return this.rank.prizeAmount * totalCount
    }
}
