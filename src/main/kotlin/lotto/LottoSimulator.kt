package lotto

import lotto.domain.LottoResult
import lotto.provider.ticket.AutoTicketProvider
import lotto.provider.winningnumber.UserWinningNumberProvider
import lotto.view.InputView
import lotto.view.ResultView
import lotto.view.UserInputView

class LottoSimulator(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun simulate(): LottoResult {
        val budget = inputView.provideBudget()
        val ticketCount = getTicketCount()
        val lottoTickets = inputView.provideLottoTickets(ticketCount)
        val winningNumbers = inputView.provideWinningNumber()
        val result = resultView.getResult(
            lottoTickets = lottoTickets,
            winningNumber = winningNumbers,
            ticketPrice = inputView.provideLottoPrice() * ticketCount,
            remainder = budget - inputView.provideLottoPrice() * ticketCount
        )
        resultView.printResult(result)
        return result
    }

    fun getTicketCount() = inputView.provideBudget() / inputView.provideLottoPrice()
}

fun main() {
    LottoSimulator(
        UserInputView(
            UserWinningNumberProvider(),
            AutoTicketProvider
        ),
        ResultView()
    ).simulate()
}
