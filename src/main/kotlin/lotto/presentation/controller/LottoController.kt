package lotto.presentation.controller

import lotto.domain.LottoNumber
import lotto.domain.LottoStore
import lotto.domain.LottoTickets

class LottoController(
    var tickets: LottoTickets? = null
) {
    fun purchase(req: PurchaseRequest): PurchaseResponse {
        val tickets = LottoStore()
            .buyLottoTicket(req.amount)
            .save()

        return PurchaseResponse.of(tickets)
    }

    fun evaluate(req: EvaluateRequest): EvaluateResponse {
        val purchasedTickets = tickets ?: throw IllegalArgumentException("티켓이 저장되지 않았습니다")
        val lottoResult = purchasedTickets.aggregateByRank(LottoNumber.of(req.winningTicket), req.bonusNumber)

        return EvaluateResponse.from(lottoResult)
    }

    private fun List<LottoNumber>.save(): LottoTickets =
        LottoTickets(this).also { tickets = it }
}
