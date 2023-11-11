package lotto.controller

import lotto.domain.Amount
import lotto.domain.LottoShop
import lotto.domain.LottoSpec
import lotto.domain.LottoTicketGenerator
import lotto.domain.LottoTickets
import lotto.domain.WinningNumbers

class LottoController(
    private val shop: LottoShop = LottoShop(),
    private var purchasedTickets: LottoTickets? = null,
) {
    fun purchase(request: PurchaseRequest): PurchaseResponse =
        shop.purchase(Amount(request.amount))
            .save()
            .let(::PurchaseResponse)

    fun end(request: EndLottoRequest): EndLottoResponse {
        val purchaseTickets = purchasedTickets ?: throw IllegalArgumentException("티켓이 저장되지 않았습니다")
        LottoTicketGenerator.create(request.winningNumbers)
        return purchaseTickets
            .determinePrize(WinningNumbers.of(request.winningNumbers), LottoSpec.NUMBERS_COUNT)
            .calculateTotalPrize(LottoSpec.prizesInfo)
            .calculateEarningRate(purchaseTickets.calculatePrice(LottoSpec.PRICE))
            .let(::EndLottoResponse)
    }

    private fun LottoTickets.save(): LottoTickets =
        this.also { purchasedTickets = it }
}
