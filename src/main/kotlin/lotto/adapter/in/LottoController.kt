package lotto.adapter.`in`

import lotto.adapter.out.LottoResultResponse
import lotto.adapter.out.PurchaseResponse
import lotto.domain.*

class LottoController(
    private val shop: LottoShop = LottoShop(),
    private var tickets: List<LottoTicket>? = null,
) {
    private val lottoTicketGenerator = LottoTicketGenerator()

    fun purchase(request: PurchaseRequest): PurchaseResponse =
        shop.purchase(request.amount)
            .save()
            .let(::PurchaseResponse)

    fun check(request: WinningNumbersRequest): LottoResultResponse {
        val purchasedTickets = tickets ?: throw IllegalArgumentException("티켓이 저장되지 않았습니다")
        val winningLottoTicket = WinningLottoTicket(
            lottoTicketGenerator.create(request.winningNumbers),
            LottoNumber(10)
        )

        return shop.receivePrize(purchasedTickets, winningLottoTicket).let(::LottoResultResponse)
    }


    private fun List<LottoTicket>.save(): List<LottoTicket> =
        this.also { tickets = it }
}
