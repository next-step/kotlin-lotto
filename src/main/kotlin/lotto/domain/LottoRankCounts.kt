package lotto.domain

data class LottoRankCounts(
    val value: Map<LottoRank, Int>
) {
    val totalEarningMoney by lazy {
        value.map { (rank, ticketCount) -> rank.calculateTotal(ticketCount) }.sum()
    }
}
