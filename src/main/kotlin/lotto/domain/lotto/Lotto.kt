package lotto.domain.lotto

import lotto.domain.lotto.benefit.LottoBenefit
import lotto.domain.lotto.benefit.LottoBenefitPolicy
import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.price.LottoTicketPrice
import lotto.domain.lotto.result.LottoResult
import lotto.domain.lotto.result.LottoResultMatchCountMap
import lotto.domain.lotto.ticket.LottoAnswerTicket
import lotto.domain.lotto.ticket.LottoTicketContainer

class Lotto(
    cost: Int,
    price: Int = LottoTicketPrice.DEFAULT_LOTTO_TICKET_PRICE
) {
    val lottoTicketContainer: LottoTicketContainer
    val lottoTicketPrice: LottoTicketPrice
    private val lottoCost: LottoCost
    private val lottoBenefitPolicy: LottoBenefitPolicy = LottoBenefitPolicy()

    init {
        lottoTicketPrice = LottoTicketPrice(price)
        lottoCost = LottoCost(cost, lottoTicketPrice)

        lottoTicketContainer = LottoTicketContainer(lottoCost.ticketCount)
    }

    fun result(lottoAnswerTicket: LottoAnswerTicket): LottoResult =
        LottoResult(benefit(lottoAnswerTicket), resultMatchCountMap(lottoAnswerTicket))

    fun benefit(lottoAnswerTicket: LottoAnswerTicket): LottoBenefit {
        val lottoResultCountMap = resultMatchCountMap(lottoAnswerTicket)

        return lottoBenefitPolicy.benefit(lottoResultCountMap, lottoCost)
    }

    private fun resultMatchCountMap(lottoAnswerTicket: LottoAnswerTicket): LottoResultMatchCountMap {
        return lottoTicketContainer.resultCountMap(lottoAnswerTicket)
    }
}
