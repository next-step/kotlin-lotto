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

        val winningTicket = WinningTicket.of(inputView.inputWinning(), bonusNumber = 1)
        val matchResults = lottoTickets.totalMatchResults(winningTicket)
        outputView.printWinningResult(matchResults.amountWithWinnings)
        outputView.printYield(matchResults.calculateYield())
    }
}
