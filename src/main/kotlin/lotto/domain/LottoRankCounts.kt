package lotto.domain

data class LottoRankCounts(
    val value: Map<LottoRank, Int>
) {
    val totalPrize by lazy {
        value.map { (rank, ticketCount) -> rank.calculateTotal(ticketCount) }.sum()
    }
}
