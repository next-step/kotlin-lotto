package camp.nextstep.edu.step.step2

import camp.nextstep.edu.step.step2.domain.amount.BuyAmount
import camp.nextstep.edu.step.step2.domain.lotto.Lottos
import camp.nextstep.edu.step.step2.domain.lotto.WinningLotto
import camp.nextstep.edu.step.step2.domain.store.LottoStore
import camp.nextstep.edu.step.step2.view.InputView
import camp.nextstep.edu.step.step2.view.OutputView


fun main() {
    val buyAmount = InputView.getInputValueAndReturnBuyAmount()

    val lottos = buyLottoTicketsWithAmount(buyAmount = buyAmount)

    checkLottoTicketsWinningResult(lottos = lottos)
}

private fun buyLottoTicketsWithAmount(buyAmount: BuyAmount): Lottos {
    val tickets = LottoStore.buyLottoTickets(buyAmount = buyAmount)

    val lottos = LottoStore.createNumbersByLottoTicketAmount(ticketAmount = tickets)

    val ticketElements = lottos.getLottoElements()

    OutputView.displayTicketsNumbers(
        ticketsAmount = tickets.lottoTicketAmount,
        ticketNumbers = ticketElements
    )

    return lottos
}

private fun checkLottoTicketsWinningResult(lottos: Lottos) {
    val lastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers()
    val bonusNumber = InputView.inputBonusNumber()

    val lottoResult = LottoStore.checkLottoTicketsWinningResult(
        userLottos = lottos,
        winningLotto = WinningLotto(
            winningLotto = lastWeekWinningNumbers,
            bonusNumber = bonusNumber
        )
    )

    OutputView.displayLottoResultByDto(lottoResultDto = lottoResult.calculateResultAndReturnDto())
}
