package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val cash = InputView.inputCash()
    val lottoGame = LottoGame()

    val lottoList = lottoGame.buyLotto(cash.toInt())

    OutputView.showLottoList(lottoList)

    val winningNumberList = InputView.inputWinningNumber()

    val winningStatus = lottoGame.getWinningStats(winningNumberList, lottoList)

    val winningRate = LottoMachine.createWinningRate(cash.toInt(), winningStatus)

    OutputView.showWinningStatus(winningStatus, winningRate)
}
