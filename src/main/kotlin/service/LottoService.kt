package service

import domain.LottoShuffler
import domain.LottoTicket
import domain.ProfitCalculator
import domain.WinningResult

class LottoService(
    private val profitCalculator: ProfitCalculator = ProfitCalculator(),
) {
    fun purchaseAutomaticLottoTicket(purchaseLottoCount: Int) =
        LottoTicket(List(purchaseLottoCount) { LottoShuffler.generateAutomaticLotto() })

    fun getWinningResult(
        lottoTicket: LottoTicket,
        winningNumbers: Set<Int>,
        purchaseLottoAmount: Int,
    ): WinningResult {
        val winningCountMap =
            lottoTicket.lottos
                .map { it.determineWinningType(winningNumbers) }
                .groupingBy { it }
                .eachCount()
                .withDefault { 0 }
        val profit = profitCalculator.calculateProfit(winningCountMap, purchaseLottoAmount)
        return WinningResult(winningCountMap, profit)
    }
}
