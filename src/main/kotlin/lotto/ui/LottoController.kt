package lotto.ui

import lotto.domain.LotteryTicketMachine
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbersGenerator
import lotto.ui.view.InputView
import lotto.ui.view.ResultView

class LottoController {
    fun main(args: Array<String>) {
        val purchasePrice = getPurchasePriceInput()
        val lotteryTickets = getLotteryTicket(purchasePrice)
        val listOfLottoNumbers = getLottoNumbers(lotteryTickets)

        printDrawResultStatistics()
    }

    private fun getPurchasePriceInput(): Int {
        return InputView.getPurchasePrice()
    }

    private fun getLotteryTicket(purchasePrice: Int): Int {
        return LotteryTicketMachine.ticketing(purchasePrice)
    }

    private fun getLottoNumbers(lotteryTickets: Int): List<LottoNumbers> {
        return MutableList(lotteryTickets) {
            LottoNumbers(LottoNumbersGenerator.generate())
        }
    }

    private fun printDrawResultStatistics() {
        ResultView.printDrawResultStatistics()
    }
}