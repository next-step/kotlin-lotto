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

        InputView.printBonusNumberInputMessage()
        val bonusNumber = LottoNumber.valueOf(InputView.inputBonusNumber())

        val winningRanks = purchasedLottos.findRanks(DrawNumbers(winningNumbers, bonusNumber))
        ResultView.printWinningStatistics(paymentPrice, winningRanks)
    }
}
