package lotto

import lotto.model.DrawNumbers
import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.RandomLottoGenerator
import lotto.view.InputView
import lotto.view.ResultView

object LottoApplication {
    fun run() {
        InputView.printPaymentPriceInputMessage()
        val paymentPrice = InputView.inputPaymentPrice()

        val purchasedLottos = RandomLottoGenerator.generateLottos(paymentPrice)
        ResultView.printPurchasedLottoCount(purchasedLottos.size)
        ResultView.printPurchasedLottos(purchasedLottos)

        InputView.printWinningNumbersInputMessage()
        val winningNumbers = Lotto(InputView.inputWinningNumbers())

        val winningRanks = purchasedLottos.findRanks(DrawNumbers(winningNumbers, LottoNumber.valueOf(45)))
        ResultView.printWinningStatistics(paymentPrice, winningRanks)
    }
}
