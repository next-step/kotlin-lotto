package lotto.controller

import lotto.domain.Amount
import lotto.domain.Bank
import lotto.domain.PurchaseTicketCount

class LottoController(
    private val bank: Bank = Bank(),
) {
    fun purchase(request: PurchaseRequest) {
        val amount = Amount(request.amount)
        val count = PurchaseTicketCount.from(amount)
        bank.save(amount)
    }
}
