package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val money = InputView.read()
    val lottoMachine = LottoMachine(money)
    OutputView.printPurchaseTicketResult(lottoMachine.lottoTickets)
    OutputView.printWinnerTicket()
    val lottoSummary = lottoMachine.execute()
    OutputView.printSummary(lottoSummary)
}
