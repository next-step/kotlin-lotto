package lotto.controller

import lotto.model.LottoMachine
import lotto.model.LottoStatistics
import lotto.model.LottoWinning
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(
    private val inputView: InputView = InputView,
    private val resultView: ResultView = ResultView
) {
    fun main() {
        val amount = inputView.inputPurchaseAmount()
        val lottoList = LottoMachine(amount).buyLotto()
        resultView.showBuyLotto(lottoList)

        val winNumbers = inputView.inputLottoWinningNumbers()
        val bonusNumber = inputView.inputLottoBonusNumbers()
        val winningNumbers = LottoWinning(winNumbers, bonusNumber)
        val result = winningNumbers.lottoResult(lottoList)
        val total = LottoStatistics.totalStatistics(result, amount)

        resultView.showWinningList(result)
        resultView.showTotalStatistics(total)
    }
}
