package lotto

import lotto.domain.LottoTicket
import lotto.domain.generator.ManualLottoGenerator
import lotto.domain.selling.LottoPrizeExchanger
import lotto.domain.selling.Payment
import lotto.domain.selling.PaymentResult
import lotto.domain.selling.Seller
import lotto.view.InputView
import lotto.view.ResultView

object Application {
    private val seller = Seller()

    @JvmStatic
    fun main(args: Array<String>) {
        val result = processUserPayment()
        var manualWinningNumbers: LottoTicket? = null
        while (manualWinningNumbers == null) {
            manualWinningNumbers = processWinningNumbers()
        }
        processResult(result, manualWinningNumbers)
    }

    private fun processUserPayment(): PaymentResult {
        val payment = Payment(InputView.readMoney { seller.isAcceptable(it) }.toInt())
        val result = seller.processPayment(payment)
        ResultView.printPaymentResult(result)
        return result
    }

    private fun processWinningNumbers(): LottoTicket? = try {
        ManualLottoGenerator(InputView.readWinningNumbers()).execute()
    } catch (e: IllegalArgumentException) {
        ResultView.printInvalidLottoNumbers()
        null
    }

    private fun processResult(paymentResult: PaymentResult, winningLotto: LottoTicket) {
        val exchangeResult = LottoPrizeExchanger.exchange(paymentResult, winningLotto)
        ResultView.printExchangeResult(exchangeResult, exchangeResult.rateOfReturn)
    }
}
