package lotto.controller

import lotto.domain.Amount
import lotto.domain.LottoShop
import lotto.domain.LottoTicketGenerator
import lotto.domain.LottoTickets
import lotto.domain.WinningLotto

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
        val winningLotto = WinningLotto(
            winningTicket = LottoTicketGenerator.create(request.winningNumbers),
            bonusNumber = request.bonusNumber
        )
        val result = purchaseTickets determineResultBy winningLotto
        TODO()
    }

    private fun LottoTickets.save(): LottoTickets =
        this.also { purchasedTickets = it }
}
