package lotto.domain

import lotto.common.LottoTicketPolicy

class StatisticalResultExtractor(
    private val lottoWinning: LottoWinning,
) {
    fun getMatchCount(winningAmount: WinningAmount): Int {
        val ticketResult = TicketResult(winningAmount.count, winningAmount.isBonusBallMatched)
        return lottoWinning.result[ticketResult] ?: ZERO_COUNT
    }

    fun getTotalRateOfReturn(ticketCount: Int): Double {
        return lottoWinning.totalAmount() / (ticketCount * LottoTicketPolicy.PRICE).toDouble()
    }

    companion object {
        private const val ZERO_COUNT = 0
    }
}
