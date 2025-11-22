package service

import domain.LottoShuffler
import domain.LottoWinningType
import domain.Lottos
import domain.ProfitCalculator
import domain.WinningResult

class LottoService(private val profitCalculator: ProfitCalculator = ProfitCalculator()) {
    fun generateLottos(purchaseLottoCount: Int): Lottos {
        val lottos = Lottos()
        repeat(purchaseLottoCount) {
            val generateAutomaticLotto = LottoShuffler.generateAutomaticLotto()
            lottos.addLotto(generateAutomaticLotto)
        }
        return lottos
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
