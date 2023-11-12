package lotto.domain

data class LottoResult(
    val rankCounts: LottoRankCounts,
    val earningRate: EarningRate,
) {
    companion object {
        fun of(winningLotto: WinningLotto, tickets: LottoTickets, ticketPrice: Amount): LottoResult {
            val rankCounts = tickets determineResultBy winningLotto
            val earningRate = EarningRate.of(
                purchasedAmount = tickets.calculatePrice(ticketPrice),
                earningAmount = rankCounts.totalPrize
            )
            return LottoResult(rankCounts, earningRate)
        }
    }
}
