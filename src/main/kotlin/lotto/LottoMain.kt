package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val cash = InputView.inputCash()
    val lottoGame = LottoGame()

    val purchaseLottoList = lottoGame.buyLotto(cash.toInt())

    OutputView.showLottoList(purchaseLottoList)

    val winningNumberList = InputView.inputWinningNumber()

    val winningStatus = lottoGame.getWinningStats(winningNumberList, purchaseLottoList)

    val winningRate = LottoMachine.createWinningRate(cash.toInt(), winningStatus)

    OutputView.showWinningStatus(winningStatus, winningRate)
}
