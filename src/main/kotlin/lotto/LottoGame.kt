package lotto

import lotto.domain.Lotto
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

    val inputWinningLotto = InputView.inputWinningLotto()
    val winningLotto = Lotto.createWinningLotto(inputWinningLotto)
    println(
        winningLotto.numbers.joinToString(
            separator = ", ",
            prefix = "당첨 번호는 [ ",
            postfix = " ]",
        ) { it.value.toString().padStart(2, ' ') },
    )
}
