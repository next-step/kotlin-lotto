package lotto.controller

import lotto.domain.Lottos
import lotto.domain.TotalRate
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(private val inputView: InputView, private val resultView: ResultView) {

    fun start() {
        val budget = inputView.inputBudget()
        val lottos = Lottos(budget)
        resultView.viewPurchaseLotto(lottos.buy())
        val winningNumber = inputView.inputWinningNumber()
        val lottoResult = lottos.correspondToWinningNumber(winningNumber)
        resultView.viewLottoResults(lottoResult, TotalRate.calculatingOf(lottoResult))
    }
}
