package lotto.model.game

import lotto.model.input.InputReader
import lotto.view.InputView
import lotto.view.ResultView

class LottoGameController(private val lottoGame: LottoGame) {
    fun ready() {
        InputView.printBudgetQuestion()
        val lottoCount = lottoGame.ready()

        ResultView.printLottoCount(lottoCount)
    }

    fun buy(inputReader: InputReader) {
        InputView.printManualCountQuestion()
        val manualCount = inputReader.readManualCount()

        InputView.printManualNumberQuestion()
        lottoGame.selectByManual(manualCount)
        val totalLotto = lottoGame.buyByAuto(manualCount)

        ResultView.printMyLottos(totalLotto)
    }

    fun match() {
        InputView.printWinningNumberQuestion()
        val winningLottoNumbers: Lotto = lottoGame.selectWinningLotto()

        InputView.printBonusBallQuestion()
        val bonusNumber: LottoNumber = lottoGame.selectBonusBall(winningLottoNumbers)
        val winningLotto = WinningLotto(winningLottoNumbers, bonusNumber)
        val gameResult = lottoGame.getResult(winningLotto)

        ResultView.printResult(gameResult)
    }

    fun getEarningRate() {
        val earningRate = lottoGame.getEarningRate()
        ResultView.printEarningRate(earningRate)
    }
}
