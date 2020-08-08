package lotto

import lotto.domain.Lotto
import lotto.domain.generator.ManualLottoGenerator
import lotto.domain.selling.LottoExchanger
import lotto.domain.selling.Payment
import lotto.domain.selling.Seller
import lotto.view.InputView
import lotto.view.ResultView

object Application {
    private val seller = Seller()

    @JvmStatic
    fun main(args: Array<String>) {
        val payment = Payment(InputView.readMoney { seller.isAcceptable(it) }.toInt())
        val result = seller.processPayment(payment)
        ResultView.printPaymentResult(result)

        val numbers = InputView.readWinningNumbers { ManualLottoGenerator.isAcceptable(it) }
        val winningNumbers = Lotto(ManualLottoGenerator(numbers))
        val exchangeResult = LottoExchanger.exchange(result.lottoes, winningNumbers)
        ResultView.printExchangeResult(exchangeResult)
    }
}
