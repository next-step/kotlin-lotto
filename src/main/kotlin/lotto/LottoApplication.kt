package lotto

import lotto.model.DrawNumbers
import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.model.LottoNumber
import lotto.model.Lottos
import lotto.model.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

object LottoApplication {
    fun run(inputView: InputView, resultView: ResultView) {
        inputView.printPaymentPriceInputMessage()
        val paymentPrice = inputView.inputPaymentPrice()

        inputView.printCustomLottoCountInputMessage()
        val customLottoCount = inputView.inputCustomLottoCount()

        inputView.printCustomLottoInputMessage()
        val customLottos = mutableListOf<Lotto>()
        repeat(customLottoCount) {
            customLottos.add(inputView.inputCustomLotto())
        }

        val totalLottos = LottoGenerator.generateLottos(
            paymentPrice = paymentPrice,
            customLottos = Lottos(customLottos)
        )
        resultView.printLottoCount(
            customLottoCount = customLottoCount,
            randomLottoCount = totalLottos.count - customLottoCount,
        )
        resultView.printTotalLottos(totalLottos)

        inputView.printWinningNumbersInputMessage()
        val winningNumbers = Lotto(inputView.inputWinningNumbers())

        inputView.printBonusNumberInputMessage()
        val bonusNumber = LottoNumber.valueOf(inputView.inputBonusNumber())

        val winningRanks = totalLottos.findRanks(DrawNumbers(winningNumbers, bonusNumber))
        resultView.printWinningStatistics(paymentPrice, WinningStatistics.from(winningRanks))
    }
}
