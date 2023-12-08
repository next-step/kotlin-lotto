package lotto

import lotto.domain.LottoPurchaseOrder
import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.RankResult
import lotto.provider.ticket.ActualLottoShop
import lotto.provider.ticket.LottoShop
import lotto.view.InputView
import lotto.view.ResultView
import lotto.view.UserInputView

class LottoSimulator(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun simulate(lottoShop: LottoShop): LottoResult {
        val purchaseOrder = LottoPurchaseOrder(
            budget = inputView.getBudget(),
            ticketPrice = LottoTicket.PRICE,
        )

        val lottoTickets = createLottoTickets(lottoShop, purchaseOrder.ticketCount)

        val winningNumber = inputView.getWinningNumber()

        val lottoResult = lottoTickets.getRankResult(winningNumber)

        val result = LottoResult(
            totalTicketPrice = purchaseOrder.totalPrice,
            totalPrize = lottoResult.totalPrize(),
            remainder = purchaseOrder.remainder
        )

        printLottoResult(lottoResult, result)

        return result
    }

    private fun printLottoResult(lottoResult: RankResult, result: LottoResult) {
        resultView.printRankResults(lottoResult)
        resultView.printResult(result)
    }

    private fun createLottoTickets(lottoShop: LottoShop, ticketCount: Int): LottoTickets {
        val manualLottoCount = inputView.getManualLottoCount()

        val manualTickets = if (manualLottoCount != 0) {
            inputView.printManualLottoInputString()
            lottoShop.provideManualTickets(manualLottoCount)
        } else LottoTickets(listOf())

        val autoTickets = lottoShop.provideAutoTickets(ticketCount - manualLottoCount)
        inputView.printPurchasedLotto(autoLottoTickets = autoTickets, manualLottoTickets = manualTickets)

        return LottoTickets(manualTickets.lottoTicketList + autoTickets.lottoTicketList)
    }
}

fun main() {
    LottoSimulator(
        UserInputView(),
        ResultView()
    ).simulate(lottoShop = ActualLottoShop)
}
