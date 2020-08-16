package lotto

import lotto.domain.generator.ManualLottoGenerator
import lotto.domain.lotto.WinningLottoTicket
import lotto.domain.selling.Payment
import lotto.domain.selling.PaymentResult
import lotto.domain.selling.Seller
import lotto.view.InputView
import lotto.view.ResultView

object Application {
    private val seller = Seller()

    @JvmStatic
    fun main(args: Array<String>) {
        val money = InputView.readMoney { seller.isAcceptable(it) }
        val manualCount = InputView.readManualCount { Payment.isValidManualCount(it, money) }
        val manualLottoTickets = List(manualCount) {
            ManualLottoGenerator.execute(inputManualNumbers(manualCount, it))
        }.filterNotNull()

        val payment = Payment(money, manualCount, manualLottoTickets)
        val paymentResult = processUserPayment(payment)
        val exchangeResult = paymentResult.exchange(requestWinningLottoTicket())
        ResultView.printExchangeResult(exchangeResult)
    }

    private fun inputManualNumbers(manualCount: Int, index: Int) =
        InputView.readManualNumbers(manualCount - index) {
            ManualLottoGenerator.execute(it) != null
        }

    private fun processUserPayment(payment: Payment): PaymentResult {
        val result = seller.processPayment(payment)
        ResultView.printPaymentResult(result)
        return result
    }

    private fun requestWinningLottoTicket(): WinningLottoTicket {
        var lottoTicket = ManualLottoGenerator.execute(InputView.readWinningNumbers())
        while (lottoTicket == null) {
            ResultView.printInvalidLottoNumbers()
            lottoTicket = ManualLottoGenerator.execute(InputView.readWinningNumbers())
        }

        var winningLottoTicket = WinningLottoTicket(lottoTicket, InputView.readBonusNumber())
        while (winningLottoTicket == null) {
            ResultView.printInvalidBonusNumber()
            winningLottoTicket = WinningLottoTicket(lottoTicket, InputView.readBonusNumber())
        }

        return winningLottoTicket
    }
}
