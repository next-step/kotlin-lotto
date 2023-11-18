package lotto.domain

class LottoResult(
    val rankCounts: LottoRankCounts,
    val earningRate: EarningRate
) {

    companion object {
        fun of(tickets: LottoTickets, winningTicket: WinningLottoTicket, ticketPrice: Int): LottoResult {
            val rankCounts = tickets.determineResultBy(winningTicket)
            val earningRate = EarningRate.of(
                purchasedAmount = tickets.calculateTotalPriceBy(ticketPrice),
                earningAmount = rankCounts.totalEarningMoney
            )

            return LottoResult(rankCounts, earningRate)
        }
    }
}