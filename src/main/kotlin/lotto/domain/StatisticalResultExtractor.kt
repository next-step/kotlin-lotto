package lotto.domain

import lotto.common.LottoTicketPolicy

class StatisticalResultExtractor(
    private val lottoWinningResult: LottoWinningResult,
) {
    fun getMatchCount(winningAmount: WinningAmount): Int {
        val ticketResult = TicketResult(winningAmount.count, winningAmount.isBonusBallMatched)
        return lottoWinningResult.result[ticketResult] ?: ZERO_COUNT
    }

    fun getTotalRateOfReturn(ticketCount: Int): Double {
        return lottoWinningResult.totalAmount() / (ticketCount * LottoTicketPolicy.PRICE).toDouble()
    }

    companion object {
        private const val ZERO_COUNT = 0
    }
}
