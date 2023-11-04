package lotto.controller

import lotto.domain.Amount
import lotto.domain.PurchaseTicketCount

object LottoController {

    fun purchase(request: PurchaseRequest) {
        val amount = Amount(request.amount)
        val count = PurchaseTicketCount.from(amount)
    }
}
