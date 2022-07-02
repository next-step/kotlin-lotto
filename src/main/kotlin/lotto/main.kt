package lotto

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputMoney = InputView.inputMoney()
    val purchaseLottos = LottoService.purchase(inputMoney)

    ResultView.printPurchaseLottos(purchaseLottos)

    val (winningNumbers, bonusNumber) = InputView.inputWinningLotto()
    val calculateResult = LottoService.calculateResult(winningNumbers, bonusNumber)

    ResultView.printResult(calculateResult)
}
