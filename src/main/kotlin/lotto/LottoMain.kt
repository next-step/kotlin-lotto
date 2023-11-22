package lotto

import lotto.domain.LottoMachine
import lotto.domain.RandomLogic
import lotto.service.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val cash = InputView.inputCash()
    val lottoGame = LottoGame(RandomLogic())
    val gameTimes = lottoGame.getGameTimes(cash)
    val manualGameTimes = InputView.inputManualCnt(gameTimes)

    val numberCombinationList = InputView.inputNumberCombination(manualGameTimes)

    val purchaseLottoList = lottoGame.buyLotto(gameTimes, numberCombinationList)

    OutputView.showLottoList(purchaseLottoList, manualGameTimes)

    val winningNumberCombination = InputView.inputWinningNumber()
    val bonusNumber = InputView.inputBonusNumber()

    val winningLotto = LottoMachine.createWinningLotto(winningNumberCombination, bonusNumber)
    val winningStatus = lottoGame.getWinningStats(winningLotto, purchaseLottoList)
    val winningRate = LottoMachine.createWinningRate(cash, winningStatus)

    OutputView.showWinningStatus(winningStatus, winningRate)
}
