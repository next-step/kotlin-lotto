package lotto

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputMoney = InputView.inputMoney()
    val inputManualLottoCount = InputView.inputManualLottoCount()
    val inputManualLottos = InputView.inputManualLottoNumbers(inputManualLottoCount)

    val purchaseLottos = LottoService.purchase(inputManualLottos, inputMoney)

    ResultView.printPurchaseLottos(purchaseLottos)

    val (winningNumbers, bonusNumber) = InputView.inputWinningLotto()
    val calculateResult = LottoService.calculateResult(winningNumbers, bonusNumber)

    ResultView.printResult(calculateResult)
}
