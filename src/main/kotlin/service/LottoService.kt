package service

import domain.LottoShuffler
import domain.LottoTicket
import domain.LottoWinningType
import domain.ProfitCalculator
import domain.WinningResult

class LottoService(private val profitCalculator: ProfitCalculator = ProfitCalculator()) {
    fun generateLottoTicket(purchaseLottoCount: Int): LottoTicket {
        return LottoTicket(List(purchaseLottoCount) { LottoShuffler.generateAutomaticLotto() })
    }

    fun getWinningResult(
        lottoTicket: LottoTicket,
        winningNumbers: List<Int>,
        purchaseLottoAmount: Int,
    ): WinningResult {
        val result =
            lottoTicket.lottoTicket
                .groupingBy { LottoWinningType.getLottoWinningType(winningNumbers, it.lotto) }
                .eachCount()
                .withDefault { 0 }
        val profit = profitCalculator.calculateProfit(result, purchaseLottoAmount)

        return WinningResult(result, profit)
    }
}
