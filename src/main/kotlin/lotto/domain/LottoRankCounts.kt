package lotto.domain

data class LottoRankCounts(
    val rankCounts: Map<LottoRank, Int>
) {
    val totalPrize by lazy {
        rankCounts.map { (rank, ticketCount) -> rank.calculateTotal(ticketCount) }.sum()
    }
}
