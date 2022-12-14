package lotto.domain.lotto

import lotto.domain.lotto.benefit.LottoBenefit
import lotto.domain.lotto.benefit.LottoBenefitPolicy
import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.price.LottoTicketPrice
import lotto.domain.lotto.result.LottoResult
import lotto.domain.lotto.result.LottoResultMap
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

        lottoTicketContainer = LottoTicketContainer.havingSizeOf(lottoCost.ticketCount)
    }

    fun result(lottoAnswerTicket: LottoAnswerTicket): LottoResult {
        val lottoResultMap = resultMap(lottoAnswerTicket)

        return LottoResult(benefit(lottoResultMap), lottoResultMap)
    }

    fun benefit(lottoAnswerTicket: LottoAnswerTicket): LottoBenefit {
        val lottoResultMap = resultMap(lottoAnswerTicket)

        return benefit(lottoResultMap)
    }

    private fun resultMap(lottoAnswerTicket: LottoAnswerTicket): LottoResultMap =
        lottoAnswerTicket.result(lottoTicketContainer)

    private fun benefit(lottoResultMap: LottoResultMap): LottoBenefit =
        lottoBenefitPolicy.benefit(lottoResultMap, lottoCost)
}
