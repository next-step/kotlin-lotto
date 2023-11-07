package lotto

import lotto.domain.LottoResult
import lotto.provider.ticket.LottoTicketsProvider
import lotto.view.InputView
import lotto.view.ResultView

class LottoSimulator(
    private val inputView: InputView,
    private val lottoTicketsProvider: LottoTicketsProvider,
    private val resultView: ResultView,
) {
    fun getTicketCount(): Int {
        val budget = inputView.provideBudget()
        return budget / lottoTicketsProvider.provideLottoPrice()
    }

    fun getTicketPrice(): Int = lottoTicketsProvider.provideLottoPrice() * getTicketCount()

    fun simulate(): LottoResult {
        val lottoTickets = lottoTicketsProvider.provideLottoTickets(getTicketCount())
        val winningNumbers = inputView.provideWinningNumbers()
        val result = resultView.getResult(
            lottoTickets,
            winningNumbers,
            getTicketPrice(),
            inputView.provideBudget() - getTicketPrice()
        )
        resultView.printResult(result)
        return result
    }
}
