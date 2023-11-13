package lotto.domain

import lotto.domain.enums.RANK
import lotto.dto.PurchaseAmount
import lotto.dto.ROI
import lotto.vo.LottoTicket

object PrizeEvaluator {
    fun evaluate(userLottoTicket: LottoTicket, winningLottoTicket: LottoTicket): Prize {
        val prize = when (userLottoTicket.countSameNumber(winningLottoTicket)) {
            RANK.FOURTH.sameNumber -> RANK.FOURTH.prize
            RANK.THIRD.sameNumber -> RANK.THIRD.prize
            RANK.SECOND.sameNumber -> RANK.SECOND.prize
            RANK.FIRST.sameNumber -> RANK.FIRST.prize
            else -> Prize(0)
        }

        return prize
    }

    private fun evaluateTotalPrize(lottoTickets: List<LottoTicket>, winningLottoTicket: LottoTicket): Prize {
        return Prize(lottoTickets.sumOf { ticket -> evaluate(ticket, winningLottoTicket).value })
    }

    fun calculateROI(
        lottoTickets: List<LottoTicket>,
        winningLottoTicket: LottoTicket,
        purchaseAmount: PurchaseAmount
    ): ROI {
        val prize = evaluateTotalPrize(lottoTickets, winningLottoTicket).value.toDouble()

        return ROI(prize / purchaseAmount.amount)
    }
}
