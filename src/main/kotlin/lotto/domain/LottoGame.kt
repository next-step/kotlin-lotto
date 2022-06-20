package lotto.domain

import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
    private val lottoTicketSeller: LottoTicketSeller = LottoTicketSeller(),
) {
    fun play() {
        val lottoTickets = lottoTicketSeller.buyLottoTickets(Money(inputView.inputBigDecimal()))
        outputView.printLottos(lottoTickets.values)

        val inputWinningNumbers = inputView.inputWinningNumbers()
        val inputBonusNumber = inputView.inputBonusNumber()
        val winningTicket = WinningTicket.of(
            lottoNumbers = inputWinningNumbers,
            bonusNumber = inputBonusNumber
        )

        val matchResults = lottoTickets.totalMatchResults(winningTicket)
        outputView.printWinningResult(matchResults.amountWithWinnings)
        outputView.printYield(matchResults.calculateYield())
    }
}
