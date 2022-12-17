package lotto

import lotto.domain.LottoDispenser
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()

    val amount = inputView.inputPurchasingAmount()
    val manualLottoCount = inputView.inputManualLottoCount()
    val manualLottoNumberText: List<String> = inputView.inputManualLottoNumbers(manualLottoCount)

    val dispenser = LottoDispenser(amount, manualLottoNumberText)

    val resultView = ResultView()
    resultView.showPurchaseResult(dispenser)

    val winningNumbers = inputView.inputWinningNumbers()
    val bonusNumber = inputView.inputBonusNumber()

    dispenser.checkWinningLottoList(winningNumbers, bonusNumber)

    resultView.showResult(dispenser)
}
