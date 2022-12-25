package lotto.domain

import lotto.common.LottoTicketPolicy

class StatisticalResultExtractor(
    private val lottoWinning: LottoWinning,
) {
    fun getMatchCount(count: Int): Int {
        return lottoWinning.result[count] ?: ZERO_COUNT
    }

    fun getTotalRateOfReturn(ticketCount: Int): Double {
        return lottoWinning.totalAmount() / (ticketCount * LottoTicketPolicy.PRICE).toDouble()
    }

    companion object {
        private const val ZERO_COUNT = 0
    }
}
