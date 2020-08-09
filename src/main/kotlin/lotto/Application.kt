package lotto

import lotto.domain.LottoNumber
import lotto.domain.WinningLottoTicket
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
        val paymentResult = inputUserPayment()
        var winningLotto: WinningLottoTicket? = null

        while (winningLotto == null) {
            winningLotto = inputWinningLotto()
        }

        val exchangeResult = LottoPrizeExchanger.exchange(paymentResult, winningLotto)
        ResultView.printExchangeResult(exchangeResult, exchangeResult.rateOfReturn)
    }

    private fun inputUserPayment(): PaymentResult {
        val payment = Payment(InputView.readMoney { seller.isAcceptable(it) }.toInt())
        val result = seller.processPayment(payment)
        ResultView.printPaymentResult(result)
        return result
    }

    private fun inputWinningLotto(): WinningLottoTicket? = try {
        val lottoTicket = ManualLottoGenerator(InputView.readWinningNumbers()).execute()
        val bonus = LottoNumber(InputView.readBonusNumber())
        WinningLottoTicket(lottoTicket, bonus)
    } catch (e: IllegalArgumentException) {
        ResultView.printInvalidLottoNumbers()
        null
    }
}
