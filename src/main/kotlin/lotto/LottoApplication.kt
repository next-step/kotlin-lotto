package lotto

import lotto.model.DrawNumbers
import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.model.LottoNumber
import lotto.model.Lottos
import lotto.model.RandomLottoGenerating
import lotto.model.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

object LottoApplication {
    fun run(inputView: InputView, resultView: ResultView) {
        inputView.printPaymentPriceInputMessage()
        val paymentPrice = inputView.inputPaymentPrice()

        val purchasedLottos =
            LottoGenerator.generateLottos(
                paymentPrice, Lottos(listOf(Lotto(LottoNumber.LOTTO_NUMBERS.subList(0, 6)))),
                RandomLottoGenerating
            )
        resultView.printPurchasedLottoCount(purchasedLottos.count)
        resultView.printPurchasedLottos(purchasedLottos)

        inputView.printWinningNumbersInputMessage()
        val winningNumbers = Lotto(inputView.inputWinningNumbers())

        inputView.printBonusNumberInputMessage()
        val bonusNumber = LottoNumber.valueOf(inputView.inputBonusNumber())

        val winningRanks = purchasedLottos.findRanks(DrawNumbers(winningNumbers, bonusNumber))
        resultView.printWinningStatistics(paymentPrice, WinningStatistics.from(winningRanks))
    }
}
