package lotto

import lotto.utils.LottoNumberMatchComparator
import lotto.domain.LottoGameResult
import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasedAmount = InputView.purchaseAmountInput()

    val lottoMachine = LottoMachine()
    val ticketAmount = lottoMachine.getTicketAmount(purchasedAmount)

    ResultView.printTicketAmount(ticketAmount)

    val ticketBundle = lottoMachine.ticketing(purchasedAmount)

    val winningNumber = InputView.winningNumberInput()

    val rank = LottoNumberMatchComparator.compare(ticketBundle, winningNumber)

    val lottoGameResult = LottoGameResult(rank)
    val rate = lottoGameResult.getRateOfReturn(purchasedAmount)

    ResultView.printRateOfReturn(rate)
}
