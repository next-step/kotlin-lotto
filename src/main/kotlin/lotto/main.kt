package lotto

import lotto.domain.LottoMachine
import lotto.view.ResultView

fun main() {
    val lottoMachine = LottoMachine(1000)
    val amount = 14000
    val tickets = lottoMachine.generateTickets(amount)
    ResultView.showTickets(tickets)
}
