package lotto

import lotto.domain.LottoMachine
import lotto.model.LottoNumber
import lotto.model.WinningLotto

fun main() {
    val purchaseAmount = InputView.inputPurchaseAmount()
    val lotto = LottoMachine().draw(purchaseAmount)
    val winningLotto = issueWinningLotto()
}

private fun issueWinningLotto(): WinningLotto =
    InputView.inputWinningNumbers()
        .map(::LottoNumber).let(::WinningLotto)
