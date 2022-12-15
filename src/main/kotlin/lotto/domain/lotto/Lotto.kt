package lotto.domain.lotto

import lotto.domain.lotto.benefit.LottoBenefit
import lotto.domain.lotto.benefit.LottoBenefitPolicy
import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.price.LottoTicketPrice
import lotto.domain.lotto.result.LottoResult
import lotto.domain.lotto.result.LottoResultMap
import lotto.domain.lotto.ticket.LottoAnswerTicket
import lotto.domain.lotto.ticket.LottoTicket
import lotto.domain.lotto.ticket.LottoTicketContainer

class Lotto(
    cost: Int,
    price: Int = LottoTicketPrice.DEFAULT_LOTTO_TICKET_PRICE,
    customLottoTicketList: List<LottoTicket> = emptyList()
) {
    val lottoTicketContainer: LottoTicketContainer
    val lottoTicketPrice: LottoTicketPrice
    private val lottoCost: LottoCost
    private val lottoBenefitPolicy: LottoBenefitPolicy = LottoBenefitPolicy()

    val customLottoTicketCount: Int = customLottoTicketList.size

    val randomGeneratedLottoTicketCount: Int
        get() = lottoTicketContainer.size - customLottoTicketCount

    init {
        lottoTicketPrice = LottoTicketPrice(price)
        lottoCost = LottoCost(cost, lottoTicketPrice)

        require(customLottoTicketList.size <= lottoCost.ticketCount) {
            "Custom lotto ticket list size should be less or equal than total ticket count " +
                    "[${customLottoTicketList.size} <= ${lottoCost.ticketCount}]"
        }

        lottoTicketContainer = LottoTicketContainer.havingSizeOf(
            ticketCount = lottoCost.ticketCount,
            customLottoTicketList = customLottoTicketList
        )
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
