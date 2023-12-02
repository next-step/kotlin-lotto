package camp.nextstep.edu.step.step2

import camp.nextstep.edu.step.step2.domain.lotto.WinningLotto
import camp.nextstep.edu.step.step2.domain.store.LottoStore
import camp.nextstep.edu.step.step2.view.InputView
import camp.nextstep.edu.step.step2.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val buyAmount = inputView.getInputValueAndReturnBuyAmount()
    val tickets = LottoStore.buyLottoTickets(buyAmount = buyAmount)

    val lottos = LottoStore.createNumbersByLottoTicketAmount(ticketAmount = tickets)

    val ticketElements = lottos.getLottoElements()

    outputView.displayTicketsNumbers(
        ticketsAmount = tickets.lottoTicketAmount,
        ticketNumbers = ticketElements
    )

    val lastWeekWinningNumbers = inputView.inputLastWeekWinningNumbers()

    val lottoResult = LottoStore.checkLottoTicketsWinningResult(
        userLottos = lottos,
        winningLotto = WinningLotto(
            winningLotto = lastWeekWinningNumbers
        )
    )

    outputView.displayLottoResultByDto(lottoResultDto = lottoResult.calculateResultAndReturnDto())
}
