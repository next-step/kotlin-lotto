package camp.nextstep.edu.step.step2

import camp.nextstep.edu.step.step2.domain.lotto.WinningLotto
import camp.nextstep.edu.step.step2.domain.store.LottoStore
import camp.nextstep.edu.step.step2.view.InputView
import camp.nextstep.edu.step.step2.view.OutputView
import java.util.stream.Collectors

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val buyAmount = inputView.getInputValueAndReturnBuyAmount()
    val tickets = LottoStore.buyLottoTickets(buyAmount = buyAmount)

    val ticketsNumbers = tickets.createNumbersByLottoTicketAmount()

    val ticketElements = ticketsNumbers.stream()
        .map { it.getNumberElements() }
        .collect(Collectors.toList())

    outputView.displayTicketsNumbers(
        ticketsAmount = tickets.lottoTicketAmount,
        ticketNumbers = ticketElements
    )

    val lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers()

    val lottoResult = LottoStore.checkLottoTicketsWinningResult(
        winningLotto = WinningLotto(
            userLottoTickets = ticketsNumbers,
            winningLotto = lastWeekWinningNumbers
        )
    )

    outputView.displayLottoResult(lottoResult = lottoResult)
}
