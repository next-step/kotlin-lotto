package lotto

import lotto.domain.LottoAmount
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val amount = InputView.inputLottoAmount()
    val ticketCount = LottoAmount(amount).ticketCount
    ResultView.displayLottoTicketCount(ticketCount)
}
