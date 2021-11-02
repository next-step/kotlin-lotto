package lotto.controller

import lotto.domain.LottoResults
import lotto.domain.Lottos
import lotto.domain.TotalRate
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(private val inputView: InputView, private val resultView: ResultView) {

    fun start() {
        val budget = inputView.inputBudget()
        val lottos = Lottos.buy(budget)
        resultView.viewPurchaseLotto(lottos.toList())
        val winningNumber = inputView.inputWinningNumber()
        val bonusNumber = inputView.inputBonusNumber()
        val lottoResults = LottoResults.matchingWinningNumber(winningNumber, bonusNumber, lottos.toList())
        resultView.viewLottoResults(lottoResults, TotalRate.calculatingOf(lottoResults))
    }
}
