package step2Lotto.controller

import step2Lotto.domain.LottoService
import step2Lotto.view.InputIO
import step2Lotto.view.InputMessage
import step2Lotto.view.InputView
import step2Lotto.view.ResultView

class LottoController {
    private val inputIO = InputIO()
    private val inputView = InputView()
    private val lottoService = LottoService()
    private val resultView = ResultView()

    fun inputPurchaseAmount(): Int {
        inputView.show(InputMessage.PURCHASE_AMOUNT)
        return inputIO.inputPurchaseAmount()
    }

    fun purchaseLottoTickets(purchaseAmount: Int): List<Lotto> {
        val lottoTicketQuantity = lottoService.getLottoTicketQuantity(purchaseAmount)
        resultView.showLottoTicketQuantity(lottoTicketQuantity)
        return lottoService.purchaseLottoTickets(lottoTicketQuantity)
    }
}
