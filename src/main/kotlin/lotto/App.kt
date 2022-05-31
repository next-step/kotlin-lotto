package lotto

import lotto.domain.Extractor
import lotto.domain.LottoMachine
import lotto.domain.LottoWinning
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getMoney()

    val manualTicketCount = InputView.getManualTicketCount()

    val manualNumbers = InputView.getManualNumbers(manualTicketCount)

    val lottoMachine = LottoMachine()

    val purchase = lottoMachine.purchase(money, manualNumbers, Extractor.randomNumberFunc)

    ResultView.printTickets(purchase)

    val lottoWinning = LottoWinning(
        numbers = InputView.getWinningNumbers(),
        bonusNumber = InputView.getBonusNumber()
    )

    val lottoPrizes = lottoWinning.getPrizes(purchase.totalTickets)

    ResultView.printResult(lottoPrizes.prizeResult, lottoPrizes.earnings(money))
}
