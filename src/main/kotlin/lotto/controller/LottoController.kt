package lotto.controller

import lotto.domain.Amount
import lotto.domain.LottoSpec
import lotto.domain.LottoTicket
import lotto.domain.LottoTicketGenerator
import lotto.domain.LottoTickets
import lotto.domain.WinningNumbers

class LottoController(
    private val ticketGenerator: LottoTicketGenerator = LottoTicketGenerator(),
    private var tickets: LottoTickets? = null,
) {
    fun purchase(request: PurchaseRequest): PurchaseResponse =
         Amount(request.amount).purchase(LottoSpec.PRICE)
            .runForCount { ticketGenerator.create() }
            .save()
            .let(::PurchaseResponse)

    fun end(request: EndLottoRequest): EndLottoResponse {
        val purchaseTickets = tickets ?: throw IllegalArgumentException("티켓이 저장되지 않았습니다")
        val prize = purchaseTickets
            .determinePrize(WinningNumbers.of(request.winningNumbers), LottoSpec.NUMBERS_COUNT)
            .calculateTotalPrize(LottoSpec.prizesInfo)
        val earningRate = prize.calculateEarningRate(purchaseTickets.calculatePrice(LottoSpec.PRICE))
        return EndLottoResponse(earningRate)
    }


    private fun doPurchase(amount: Int) = Amount(amount).purchase(LottoSpec.PRICE)
        .runForCount { ticketGenerator.create() }
        .save()

    private fun List<LottoTicket>.save(): LottoTickets =
        LottoTickets(this).also { tickets = it }
}
