package lotto.controller

import lotto.model.game.Lotto
import lotto.model.game.LottoGame
import lotto.model.game.LottoNumber
import lotto.model.game.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

class LottoGameController(private val lottoGame: LottoGame) {
    fun ready() {
        InputView.printBudgetQuestion()
        val lottoCount = lottoGame.ready()

        ResultView.printLottoCount(lottoCount)
    }

    fun buy() {
        InputView.printManualCountQuestion()
        val manualCount = lottoGame.inputReader.readManualCount()

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
        val gameResult = lottoGame.getResult(WinningLotto(winningLottoNumbers, bonusNumber))

        ResultView.printResult(gameResult)
    }

    fun getEarningRate() {
        val earningRate = lottoGame.getEarningRate()
        ResultView.printEarningRate(earningRate)
    }
}
