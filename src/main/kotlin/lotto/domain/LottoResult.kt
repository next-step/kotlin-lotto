package lotto.domain

object LottoResult {
    fun getResult(
        winningLottoTicket: WinningLottoTicket,
        lottoTickets: LottoTickets
    ): Result {
        val rankInfo = getRankInfo(winningLottoTicket, lottoTickets)
        val profitRate = getProfitRate(rankInfo, lottoTickets)
        val isProfit = profitRate > 1.0
        return Result(rankInfo, profitRate, isProfit)
    }

    private fun getRankInfo(winningLottoTicket: WinningLottoTicket, lottoTickets: LottoTickets): Map<Rank, Int> {
        val ranks = lottoTickets.tickets.map { lottoTicket -> winningLottoTicket.match(lottoTicket) }
        val eachCount = ranks.groupingBy { it }.eachCount()
        return Rank.entries.associateWith { rank -> eachCount.getOrDefault(rank, 0) }
    }

    private fun getProfitRate(rankInfo: Map<Rank, Int>, lottoTickets: LottoTickets): Double {
        val totalPrice = lottoTickets.getTicketTotalPrice()
        val totalWinningMoney = rankInfo.entries.sumOf { (rank, count) -> rank.winningMoney * count }
        return totalWinningMoney.toDouble() / totalPrice
    }

    data class Result(
        val rankInfo: Map<Rank, Int>,
        val profitRate: Double,
        val isProfit: Boolean,
    )
}
