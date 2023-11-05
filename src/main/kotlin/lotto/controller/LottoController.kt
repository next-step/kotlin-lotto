package lotto.controller

import lotto.domain.Amount
import lotto.domain.Bank
import lotto.domain.LottoManager
import lotto.domain.TicketCount
import lotto.domain.WinningNumbers

class LottoController(
    private val lottoManager: LottoManager = LottoManager(),
    private val bank: Bank = Bank(),
) {
    fun purchase(request: PurchaseRequest): PurchaseResponse {
        val amount = Amount(request.amount)
        val tickets = lottoManager.createTicket(TicketCount.from(amount))
        bank.save(amount)
        return PurchaseResponse(tickets)
    }

    fun end(request: EndLottoRequest) {
        val winningNumbers = WinningNumbers.of(request.winningNumbers)
    }
}
