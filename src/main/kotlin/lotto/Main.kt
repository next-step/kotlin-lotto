package lotto

import lotto.domain.LottoDispenser
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()

    val amount = inputView.inputPurchasingAmount()
    val dispenser = LottoDispenser(amount)

    val resultView = ResultView()
    resultView.showPurchaseResult(dispenser.lottoList)

    dispenser.winningNumbers = inputView.inputWinningNumbers()
    dispenser.bonusNumber = inputView.inputBonusNumber()

    resultView.showResult(dispenser)
}
