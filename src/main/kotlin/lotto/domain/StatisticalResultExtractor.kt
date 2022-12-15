package lotto.domain

import lotto.common.LottoTicketPolicy

class StatisticalResultExtractor(
    private val lottoWinning: LottoWinning,
) {
    fun getMatchCount(count: Int): Int {
        return lottoWinning.result[count] ?: ZERO_COUNT
    }

    fun getTotalRateOfReturn(ticketCount: Int): Double {
        var totalAmount = 0L
        lottoWinning.result.entries.map {
            totalAmount += WinningAmount.from(it.key).amount * it.value
        }

        return totalAmount / (ticketCount * LottoTicketPolicy.PRICE).toDouble()
    }

    companion object {
        private const val ZERO_COUNT = 0
    }
}
