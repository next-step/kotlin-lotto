package lotto.domain

import lotto.domain.lottoticket.LottoNumbers
import lotto.domain.lottoticket.LottoTickets
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun play() {
        val totalTickets = lottoTickets()
        outputView.printTotalTicketCount(totalTickets)
        val winningTicket = winningTicket()
        val matchResults = totalTickets.totalMatchResults(winningTicket)
        outputView.printWinningResult(matchResults.amountWithWinnings)
        outputView.printYield(matchResults.calculateYield())
    }

    private fun lottoTickets(): LottoTickets {
        val lottoShop = LottoShop()
        var money = Money(inputView.inputMoney())
        val manualNumbersList = lottoNumbersList()

        while (lottoShop.canNotPurchasableBy(money, manualNumbersList.count())) {
            money += Money(inputView.inputAdditionalMoney())
        }

        return lottoShop.sellLottoTickets(money, manualNumbersList)
    }

    private fun lottoNumbersList(): List<LottoNumbers> {
        val buyManualLottoTicketCount = inputView.inputManualLottoTicketCount()
        return List(buyManualLottoTicketCount) {
            LottoNumbers.createWithSortByList(inputView.inputManualLottoTicketNumbers())
        }
    }

    private fun winningTicket(): WinningTicket {
        val inputWinningNumbers = inputView.inputWinningNumbers()
        val inputBonusNumber = inputView.inputBonusNumber()
        return WinningTicket.of(lottoNumbers = inputWinningNumbers, bonusNumber = inputBonusNumber)
    }
}
