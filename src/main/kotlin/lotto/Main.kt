package lotto

import lotto.model.game.Lotto
import lotto.model.game.LottoGame
import lotto.model.game.LottoMachine
import lotto.model.game.LottoNumber
import lotto.model.game.WinningLotto
import lotto.model.input.InputReader
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoMachine = LottoMachine()
    val inputReader = InputReader()
    val lottoGame = LottoGame(lottoMachine, inputReader)

    InputView.printBudgetQuestion()
    val money = inputReader.readBudget()
    val lottoCount = lottoGame.ready(money)
    ResultView.printLottoCount(lottoCount)

    InputView.printManualCountQuestion()
    val manualCount = inputReader.readManualCount()

    InputView.printManualNumberQuestion()
    val lottoByManual = lottoGame.selectByManual(manualCount)
    val totalLotto = lottoGame.buy(lottoCount - manualCount)
    ResultView.printMyLottos(totalLotto)

    InputView.printWinningNumberQuestion()
    val winningLottoNumbers: Lotto = lottoGame.selectWinningLotto()

    InputView.printBonusBallQuestion()
    val bonusNumber: LottoNumber = lottoGame.selectBonusBall(winningLottoNumbers)

    val winningLotto = WinningLotto(winningLottoNumbers, bonusNumber)
    val gameResult = lottoGame.getResult(winningLotto)
    ResultView.printResult(gameResult)

    val earningRate = lottoGame.getEarningRate()
    ResultView.printEarningRate(earningRate)
}
