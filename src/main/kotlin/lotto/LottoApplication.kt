package lotto

import lotto.ui.LottoController
import lotto.ui.view.InputView
import lotto.ui.view.ResultView

fun main() {
    val purchasePrice = InputView.getPurchasePrice()
    val purchasedLottos = LottoController.purchaseLottos(purchasePrice)

    val winningLottoNumbers = InputView.getWinningLottoNumbers()
    val bonusLottoNumber = InputView.getBonusLottoNumber()
    val winningLotto = LottoController.drawWinningLottos(winningLottoNumbers, bonusLottoNumber)

    val roundResult = LottoController.getRoundResult(purchasedLottos, winningLotto)

    val earningRate = LottoController.calculateEarningRate(roundResult)

    ResultView.printLottoResult(roundResult, earningRate)
}
