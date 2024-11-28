package lotto

import lotto.domain.LottoAmount
import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val amount = InputView.inputLottoAmount()
    val ticketCount = LottoAmount(amount).ticketCount
    ResultView.displayLottoTicketCount(ticketCount)

    val tickets = LottoMachine.generateTickets(ticketCount)
    ResultView.printAutoGenerateLotto(tickets)

    InputView.inputWinningLotto()
}
