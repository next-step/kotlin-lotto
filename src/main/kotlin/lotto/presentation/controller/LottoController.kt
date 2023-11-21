package lotto.presentation.controller

import lotto.domain.LottoTicket
import lotto.domain.LottoStore
import lotto.domain.LottoTickets
import lotto.presentation.controller.dto.EvaluateRequest
import lotto.presentation.controller.dto.EvaluateResponse
import lotto.presentation.controller.dto.PurchaseRequest
import lotto.presentation.controller.dto.PurchaseResponse

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
        val lottoResult = purchasedTickets.aggregateByRank(LottoTicket.of(req.winningTicket), req.bonusNumber)

        return EvaluateResponse.from(lottoResult)
    }

    private fun List<LottoTicket>.save(): LottoTickets =
        LottoTickets(this).also { tickets = it }
}
