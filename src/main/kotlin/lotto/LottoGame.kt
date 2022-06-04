package lotto

import lotto.model.Lotto
import lotto.model.RandomLottoGenerator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    InputView.printPaymentPriceInputMessage()
    val paymentPrice = InputView.inputPaymentPrice()

    val purchasedLottos = RandomLottoGenerator.generateLottos(paymentPrice)
    ResultView.printPurchasedLottoCount(purchasedLottos.size)
    ResultView.printPurchasedLottos(purchasedLottos)

    InputView.printWinningNumbersInputMessage()
    val winningNumbers = Lotto(InputView.inputWinningNumbers())

    val winningRanks = purchasedLottos.findRanks(winningNumbers)
    ResultView.printWinningStatistics(paymentPrice, winningRanks)
}
