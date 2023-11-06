package lotto.controller

import lotto.domain.Amount
import lotto.domain.Bank
import lotto.domain.LottoAccountant
import lotto.domain.LottoManager
import lotto.domain.LottoSpec
import lotto.domain.WinningNumbers

class LottoController(
    private val lottoManager: LottoManager = LottoManager(),
    private val bank: Bank = Bank(),
) {
    fun purchase(request: PurchaseRequest): PurchaseResponse {
        val amount = Amount(request.amount)
        val ticketCount = LottoAccountant.calculateTicketCount(amount)
        val tickets = lottoManager.createTicket(ticketCount)
        bank.save(amount)
        return PurchaseResponse(tickets)
    }

    fun end(request: EndLottoRequest): EndLottoResponse {
        val winningNumbers = WinningNumbers.of(request.winningNumbers)
        val result = lottoManager.getResult(winningNumbers)
        val totalPrizeAmount = LottoAccountant.calculateTotalPrize(result, LottoSpec.prizesInfo)
        val earningRate = bank.receivePrize(totalPrizeAmount)
        return EndLottoResponse(earningRate)
    }
}
