package lotto.domain

data class LottoRankCounts(
    val value: Map<Rank, Int>
) {
    val totalEarningMoney by lazy {
        value.map { (rank, ticketCount) -> rank.calculateTotal(ticketCount) }.sum()
    }
}
