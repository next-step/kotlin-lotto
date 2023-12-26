package camp.nextstep.edu.step.step2

import camp.nextstep.edu.step.step2.domain.amount.BuyAmount
import camp.nextstep.edu.step.step2.domain.lotto.Lottos
import camp.nextstep.edu.step.step2.domain.lotto.WinningLotto
import camp.nextstep.edu.step.step2.domain.store.LottoStore
import camp.nextstep.edu.step.step2.dto.LottoProcessDto
import camp.nextstep.edu.step.step2.view.InputView
import camp.nextstep.edu.step.step2.view.OutputView


fun main() {
    val buyAmount = InputView.getInputValueAndReturnBuyAmount()
    val manualLottoCount = InputView.inputManualLottoCount()
    val manualLottos = InputView.inputManalLottoNumbers(ticketAmount = manualLottoCount.amount)

    val lottos = buyLottoTicketsWithAmount(buyAmount = buyAmount, manualLottos = manualLottos)

    checkLottoTicketsWinningResult(lottos = lottos)
}

private fun buyLottoTicketsWithAmount(buyAmount: BuyAmount, manualLottos: Lottos): Lottos {
    val tickets = LottoStore.buyAutoLottoTickets(
        buyAmount = buyAmount,
        manualTicketAmount = manualLottos.getLottoSize()
    )
    val lottos = LottoStore.createNumbersByLottoTicketAmount(
        ticketAmount = tickets,
        manualLottos = manualLottos
    )

    val autoLottoNumbers = lottos.getLottoElements()
    val manualLottoNumbers = manualLottos.getLottoElements()

    OutputView.displayTicketsNumbers(
        LottoProcessDto(
            manualTicketAmount = manualLottos.getLottoSize(),
            autoTicketAmount = tickets.lottoTicketAmount,
            lottoTicketList = manualLottoNumbers + autoLottoNumbers
        )
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
