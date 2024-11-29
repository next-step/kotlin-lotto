package lotto

import lotto.domain.Lotto
import lotto.domain.LottoAmount
import lotto.domain.LottoMachine
import lotto.domain.WinningMachine
import lotto.view.InputView
import lotto.view.ResultView
import lotto.view.ResultView.printWinningStatistics

fun main() {
    val amount = InputView.inputLottoAmount()
    val ticketCount = LottoAmount(amount).ticketCount
    ResultView.displayLottoTicketCount(ticketCount)

    val tickets = LottoMachine.generateTickets(ticketCount)
    ResultView.printAutoGenerateLotto(tickets)

    val inputWinningLotto = InputView.inputWinningLotto()
    val winningLotto = Lotto.createWinningLotto(inputWinningLotto)

    val calculateStatistics = WinningMachine(winningLotto).calculateStatistics(tickets)
    printWinningStatistics(calculateStatistics)
}
