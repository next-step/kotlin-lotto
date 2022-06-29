package lotto.domain

import lotto.domain.lottoticket.LottoTickets
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun play() {
        val totalTickets = lottoTickets()
        val winningTicket = winningTicket()
        val matchResults = totalTickets.totalMatchResults(winningTicket)
        outputView.printWinningResult(matchResults.amountWithWinnings)
        outputView.printYield(matchResults.calculateYield())
    }

    private fun lottoTickets(): LottoTickets {
        val money = Money(inputView.inputMoney())
        val buyManualLottoTicketCount = inputView.inputManualLottoTicketCount()
        val manualNumbersList = inputView.inputManualLottoTicketNumbers(buyManualLottoTicketCount)
        return LottoShop().sellLottoTickets(money, manualNumbersList)
    }

    private fun winningTicket(): WinningTicket {
        val inputWinningNumbers = inputView.inputWinningNumbers()
        val inputBonusNumber = inputView.inputBonusNumber()
        return WinningTicket.of(lottoNumbers = inputWinningNumbers, bonusNumber = inputBonusNumber)
    }
}
