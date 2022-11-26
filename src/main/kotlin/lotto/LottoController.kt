package lotto

import lotto.domain.TicketStore
import lotto.domain.WinningTicket
import lotto.domain.machine.RandomLottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.inputMoney()

    val tickets = TicketStore.buyTickets(RandomLottoMachine(money))
    ResultView.printTickets(tickets)

    val numbers = InputView.inputWinningNumber()
    val bonusNumber = InputView.inputBonusNumber()

    val winningTicket = WinningTicket.of(numbers, bonusNumber)

    val awardResults = tickets.awardResults(winningTicket)
    ResultView.printResults(awardResults)

}

class LottoController {
}
