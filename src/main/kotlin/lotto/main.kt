package lotto

import lotto.domain.LottoMachine
import lotto.ui.InputUI
import lotto.ui.OutputUI

fun main() {
    val amount = InputUI.receivePurchaseAmount()

    val lotto = LottoMachine.buy(amount)
    OutputUI.drawPurchaseMessage(lotto.size)
    OutputUI.drawLotto(lotto)

    val winningNumbers = InputUI.receiveWinningNumbers()
}
