package lotto

import lotto.model.Lotto
import lotto.model.Lottos
import lotto.model.WinningRank
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    InputView.printPaymentPriceInputMessage()
    val paymentPrice = InputView.inputPaymentPrice()

    val purchasedLottos = Lottos.generateLottos(paymentPrice)
    ResultView.printPurchasedLottoCount(purchasedLottos.size)
    ResultView.printPurchasedLottos(purchasedLottos)

    InputView.printWinningNumbersInputMessage()
    val winningNumbers = Lotto.of(InputView.inputWinningNumbers())

    val winningRanks = WinningRank.findRanks(purchasedLottos, winningNumbers)
    ResultView.printWinningStatistics(paymentPrice, winningRanks)
}
