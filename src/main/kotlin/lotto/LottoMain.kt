package lotto

import lotto.data.NumberCombination
import lotto.domain.LottoMachine
import lotto.domain.RandomLogic
import lotto.service.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val cash = InputView.inputCash()
    val lottoGame = LottoGame(RandomLogic())
    val purchaseLottoList = lottoGame.buyLotto(cash.toInt())

    OutputView.showLottoList(purchaseLottoList)

    val winningNumberList = NumberCombination(InputView.inputWinningNumber())
    val bonusNumber = InputView.inputBonusNumber()

    val winningLotto = LottoMachine.createWinningLotto(winningNumberList, bonusNumber)
    val winningStatus = lottoGame.getWinningStats(winningLotto, purchaseLottoList)
    val winningRate = LottoMachine.createWinningRate(cash.toInt(), winningStatus)

    OutputView.showWinningStatus(winningStatus, winningRate)
}
