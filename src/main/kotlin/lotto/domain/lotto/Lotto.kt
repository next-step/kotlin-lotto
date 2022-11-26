package lotto.domain.lotto

import lotto.domain.lotto.benefit.LottoBenefit
import lotto.domain.lotto.benefit.LottoBenefitPolicy
import lotto.domain.lotto.price.LottoCost
import lotto.domain.lotto.price.LottoTicketPrice
import lotto.domain.lotto.result.LottoResult
import lotto.domain.lotto.ticket.LottoTicketContainer


class Lotto(
    cost: Int,
    price: Int = LottoTicketPrice.DEFAULT_LOTTO_TICKET_PRICE
) {
    private val lottoBenefitPolicy: LottoBenefitPolicy = LottoBenefitPolicy()
    private val lottoCost: LottoCost = LottoCost(cost)
    val lottoTicketPrice: LottoTicketPrice = LottoTicketPrice(price)
    val lottoTicketList = LottoTicketContainer()

    init {
        require(cost >= price) { "Cost is less than price [$price]" }

        val totalLottoTicketCount = cost.div(lottoTicketPrice.price)

        repeat(totalLottoTicketCount) {
            addLottoTicket()
        }
    }

    fun benefit(lottoAnswer: LottoAnswer): LottoBenefit {
        val resultCountMap = lottoAnswer.calculate(this)

        return lottoBenefitPolicy.benefit(resultCountMap, lottoCost)
    }

    fun result(lottoAnswer: LottoAnswer): LottoResult = LottoResult(this, lottoAnswer)

    private fun addLottoTicket(): Unit = lottoTicketList.addLottoTicket()
}
