package lotto.domain

import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun play() {
        val lottoTickets = LottoTickets.buyLottos(Money(inputView.inputBigDecimal()))
        outputView.printLottos(lottoTickets.values)

        val winningTicket = WinningTicket.of(inputView.inputWinning())
        val matchResults = lottoTickets.totalMatchResults(winningTicket)
        outputView.printWinningResult(matchResults.amountWithWinnings)
        outputView.printYield(matchResults.calculateYield())
    }
}
