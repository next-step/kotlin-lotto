package lotto.presentation.controller

import lotto.domain.*
import lotto.presentation.controller.dto.EvaluateRequest
import lotto.presentation.controller.dto.EvaluateResponse
import lotto.presentation.controller.dto.PurchaseRequest
import lotto.presentation.controller.dto.PurchaseResponse

class LottoController() {
    fun purchase(req: PurchaseRequest): PurchaseResponse {
        val tickets = LottoStore()
            .buyLottoTicket(req.amount)
            .save()

        return PurchaseResponse.of(tickets)
    }

    fun evaluate(req: EvaluateRequest): EvaluateResponse {
        val purchasedTickets = tickets ?: throw IllegalArgumentException("티켓이 저장되지 않았습니다")
        val winningLottoTicket = LottoTicket.of(req.winningTicket)
        val bonusNumber = req.bonusNumber

        val winningLottoInfo = WinningLottoInfo.of(winningLottoTicket, bonusNumber)
        val lottoResult = purchasedTickets.aggregateByRank(winningLottoInfo)

        return EvaluateResponse.from(lottoResult)
    }

    private fun List<LottoTicket>.save(): LottoTickets =
        LottoTickets(this).also { tickets = it }
}
