package lotto

import lotto.domain.LottoVendingMachine
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val amount = InputView.inputAmount()
    val lottos = LottoVendingMachine.generate(amount)
    ResultView.printLottos(lottos)

    val inputWinningNumbers = InputView.inputWinningNumbers()
}
