package lotto.controller

import lotto.domain.BillSlot
import lotto.domain.LottoVendingMachine
import lotto.view.InputView

fun main() {
    val inputView = InputView()
    LottoVendingMachine(BillSlot(LottoVendingMachine.LOTTO_PRICE))
        .purchase(inputView.getPurchaseAmount())
}
