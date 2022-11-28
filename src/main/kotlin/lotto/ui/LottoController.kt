package lotto.ui

import lotto.domain.LotteryTicketMachine
import lotto.ui.view.InputView
import lotto.ui.view.ResultView

class LottoController {
    fun main(args: Array<String>) {
        val purchasePrice = getPurchasePriceInput()
        val lotteryTickets = getLotteryTicket(purchasePrice)

        println(lotteryTickets)

        printDrawResultStatistics()
    }

    private fun getPurchasePriceInput(): Int {
        return InputView.getPurchasePrice()
    }

    private fun getLotteryTicket(purchasePrice: Int): Int {
        return LotteryTicketMachine.ticketing(purchasePrice)
    }

    private fun printDrawResultStatistics() {
        ResultView.printDrawResultStatistics()
    }
}