package lotto.ui

import lotto.domain.*
import lotto.ui.view.InputView
import lotto.ui.view.ResultView

class LottoController {
    fun main(args: Array<String>) {
        val purchasePrice = getPurchasePriceInput()
        val lotteryTickets = calculateLotteryTicket(purchasePrice)
        val listOfLottoNumbers = getLottoNumbers(lotteryTickets)

        val lotteryWinningNumbersInput = getLotteryWinningNumbersInput()
        validateLotteryWinningNumbers(lotteryWinningNumbersInput)
        val lotteryWinningNumbers = LottoNumbers(lotteryWinningNumbersInput)

        print(lotteryWinningNumbers)

        printDrawResultStatistics()
    }

    private fun getPurchasePriceInput(): Int {
        return InputView.getPurchasePrice()
    }

    private fun calculateLotteryTicket(purchasePrice: Int): Int {
        return LotteryTicketMachine.ticketing(purchasePrice)
    }

    private fun getLottoNumbers(lotteryTickets: Int): List<LottoNumbers> {
        return MutableList(lotteryTickets) {
            LottoNumbers(LottoNumbersGenerator.generate())
        }
    }

    private fun getLotteryWinningNumbersInput(): List<Int> {
        return InputView.getLotteryWinningNumbers()
    }

    private fun validateLotteryWinningNumbers(lotteryWinningNumbersInput: List<Int>): Boolean {
        if(LottoNumbersValidator.validate(lotteryWinningNumbersInput))
            throw IllegalArgumentException("유효하지 않은 로또 번호입니다.")

        return true
    }

    private fun printDrawResultStatistics() {
        ResultView.printDrawResultStatistics()
    }
}