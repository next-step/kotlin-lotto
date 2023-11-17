package lotto.domain

import lotto.dto.PurchaseAmountDto
import lotto.dto.RoiDto
import lotto.domain.vo.LottoTicket

object PrizeEvaluator {

    fun calculateROI(
        lottoTickets: List<LottoTicket>,
        winningLottoTicket: LottoTicket,
        purchaseAmountDTO: PurchaseAmountDto
    ): RoiDto {
        val prize = evaluateTotalPrize(lottoTickets, winningLottoTicket).value.toDouble()

        return RoiDto(prize / purchaseAmountDTO.amount)
    }

    private fun evaluateTotalPrize(lottoTickets: List<LottoTicket>, winningLottoTicket: LottoTicket): Prize {
        return Prize(lottoTickets.sumOf { it.evaluate(winningLottoTicket).value })
    }
}
