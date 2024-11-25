package lotto.domain

import lotto.domain.rank.Rank

class LottoResult(
    private val winningLottoTicket: WinningLottoTicket,
    private val lottoTickets: LottoTickets,
) {
    fun getResult(): Result {
        val rankInfo = winningLottoTicket.matchTickets(lottoTickets)
        val profitRate = winningLottoTicket.getProfitRate(lottoTickets)
        val isProfit = profitRate > 1.0
        return Result(rankInfo, profitRate, isProfit)
    }

    data class Result(
        val rankInfo: Map<Rank, Int>,
        val profitRate: Double,
        val isProfit: Boolean,
    )
}
