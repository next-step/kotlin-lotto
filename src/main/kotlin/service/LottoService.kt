package service

import domain.LottoShuffler
import domain.LottoWinningType
import domain.Lottos
import domain.ProfitCalculator
import domain.WinningResult

class LottoService(private val profitCalculator: ProfitCalculator = ProfitCalculator()) {
    fun generateLottos(purchaseLottoCount: Int): Lottos {
        return Lottos(List(purchaseLottoCount) { LottoShuffler.generateAutomaticLotto() })
    }

    fun getWinningResult(
        lottos: Lottos,
        winningNumbers: List<Int>,
        purchaseLottoAmount: Int,
    ): WinningResult {
        val result =
            lottos.lottos
                .groupingBy { LottoWinningType.getLottoWinningType(winningNumbers, it.lotto) }
                .eachCount()
                .withDefault { 0 }
        val profit = profitCalculator.calculateProfit(result, purchaseLottoAmount)

        return WinningResult(result, profit)
    }
}
