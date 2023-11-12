package lotto.domain

data class LottoResult(
    val rankCounts: LottoRankCounts,
    val earningRate: EarningRate,
) {
    companion object {
        fun of(winningLotto: WinningLotto, ticket: LottoTicket, ticketPrice: Amount): LottoResult {
            val rankCounts = ticket determineResultBy winningLotto
            val earningRate = EarningRate.of(
                purchasedAmount = ticket.calculatePrice(ticketPrice),
                earningAmount = rankCounts.totalPrize
            )
            return LottoResult(rankCounts, earningRate)
        }
    }
}
