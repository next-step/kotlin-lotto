package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val cash = InputView.inputCash()
    val lottoGame = LottoGame()

    val lottoList = lottoGame.buyLotto(cash.toInt())

    val winningNumberList = InputView.inputWinningNumber()

    val winningStatus = lottoGame.getWinningStats(winningNumberList, lottoList)

    OutputView.showLottoList(lottoList)

    OutputView.showWinningStatus(winningStatus)
}
