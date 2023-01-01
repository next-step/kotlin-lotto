package lotto

import lotto.domain.LottoGameResult
import lotto.domain.LottoMachine
import lotto.utils.LottoNumberMatchComparator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasedAmount = InputView.purchaseAmountInput()

    val lottoMachine = LottoMachine()
    val ticketBundle = lottoMachine.ticketing(purchasedAmount)
    ResultView.printTicketBundle(ticketBundle)

    val winningNumber = InputView.winningNumberInput()

    val rank = LottoNumberMatchComparator.compare(ticketBundle, winningNumber)
    ResultView.printWinningLottoAmount(rank)

    val lottoGameResult = LottoGameResult(rank)
    val rate = lottoGameResult.getRateOfReturn(purchasedAmount)

    ResultView.printRateOfReturn(rate)
}
