package lotto.presentation.controller

import lotto.domain.*
import lotto.domain.LottoStore.Companion.LOTTO_PRICE
import lotto.presentation.controller.dto.*

class LottoController() {
    fun purchase(req: PurchaseRequest): PurchaseResponse {
        require(req.amount % LOTTO_PRICE == 0) { "구입 금액은 로또 가격의 배수여야 합니다." }

        val tickets = LottoStore()
            .buyLottoTicket(req.amount)
            .let(::LottoTickets)

        return PurchaseResponse.of(tickets)
    }

    fun evaluate(resp: PurchaseResponse, req: EvaluateRequest): EvaluateResponse {
        val purchasedTickets = LottoTickets.of(resp.tickets)
        val winningLottoTicket = LottoTicket.of(req.winningTicket)
        val bonusNumber = req.bonusNumber

        val winningLottoInfo = WinningLottoInfo.of(winningLottoTicket, bonusNumber)
        val lottoResult = purchasedTickets.aggregateByRank(winningLottoInfo)
        val resultTable = lottoResult.getResultTable()
        val earningRate = lottoResult.getEarningRate()

        val lottoResultDto = LottoResultDto.of(resultTable, earningRate)

        return EvaluateResponse.from(lottoResultDto)
    }
}
