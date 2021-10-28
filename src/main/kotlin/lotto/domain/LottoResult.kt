package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(val resultStatistics: Map<LottoResultRank, Int>, val profitRate: BigDecimal) {
    companion object {
        fun from(ticket: LottoTicket, winningInfo: WinningInfo, purchaseAmount: LottoPurchaseAmount): LottoResult {
            return LottoResult(
                getResultStatistics(ticket, winningInfo),
                getTotalProfitRate(ticket, winningInfo, purchaseAmount)
            )
        }

        private fun getResultStatistics(ticket: LottoTicket, winningInfo: WinningInfo): Map<LottoResultRank, Int> {
            return ticket.lottoPackages
                .groupingBy { it.getMatchedCount(winningInfo.winningNumberPackage).rank() }
                .eachCount()
        }

        private fun getTotalProfitRate(
            ticket: LottoTicket,
            winningInfo: WinningInfo,
            purchaseAmount: LottoPurchaseAmount
        ): BigDecimal {
            return ticket.lottoPackages
                .sumOf { it.getPrizeMoney(winningInfo.winningNumberPackage) }
                .toBigDecimal()
                .setScale(2, RoundingMode.HALF_UP)
                .div(purchaseAmount.value!!.toBigDecimal())
        }
    }
}
