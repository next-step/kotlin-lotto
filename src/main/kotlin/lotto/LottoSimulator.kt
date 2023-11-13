package lotto

import lotto.domain.LottoPurchaseOrder
import lotto.domain.LottoResult
import lotto.provider.LottoResultProvider
import lotto.provider.budget.UserInputBudgetProvider
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
        val purchaseOrder = LottoPurchaseOrder(
            budget = inputView.provideBudget(),
            ticketPrice = inputView.provideLottoPrice(),
            ticketCount = inputView.provideTicketCount(),
        )

        val result = LottoResultProvider.provideLottoResult(
            lottoTickets = inputView.provideLottoTickets(),
            winningNumber = inputView.provideWinningNumber(),
            totalTicketPurchasePrice = purchaseOrder.totalPrice,
            remainder = purchaseOrder.remainder
        )

        resultView.printResult(result)
        return result
    }
}

fun main() {
    LottoSimulator(
        UserInputView(
            UserInputBudgetProvider().provide(),
            UserWinningNumberProvider(),
            AutoTicketProvider
        ),
        ResultView()
    ).simulate()
}
