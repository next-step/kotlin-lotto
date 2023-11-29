package lotto

import lotto.domain.LottoPurchaseOrder
import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.provider.ticket.AutoTicketProvider
import lotto.view.InputView
import lotto.view.ResultView
import lotto.view.UserInputView

class LottoSimulator(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun simulate(): LottoResult {
        val purchaseOrder = LottoPurchaseOrder(
            budget = inputView.getBudget(),
            ticketPrice = LottoTicket.PRICE,
        )

        val lottoTickets = inputView.provideLottoTickets(purchaseOrder.ticketCount)
        val winningNumber = inputView.getWinningNumber()
        val lottoResult = lottoTickets.getRankResult(winningNumber)

        val result = LottoResult(
            totalTicketPrice = purchaseOrder.totalPrice,
            totalPrize = lottoResult.totalPrize(),
            remainder = purchaseOrder.remainder
        )

        resultView.printRankResults(lottoResult)
        resultView.printResult(result)
        return result
    }
}

fun main() {
    LottoSimulator(
        UserInputView(
            AutoTicketProvider
        ),
        ResultView()
    ).simulate()
}
