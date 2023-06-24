package step2Lotto.domain

import step2Lotto.domain.dto.StatisticsRequest
import step2Lotto.domain.dto.StatisticsResponse

class LottoService(
    private val lottoGenerator: LottoGenerator
) {
    fun getLottoTicketQuantity(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    fun purchaseLottoTickets(lottoTicketQuantity: Int): List<Lotto> {
        return List(lottoTicketQuantity) { lottoGenerator.execute() }
    }

    fun getStatistics(req: StatisticsRequest): StatisticsResponse {
        val lottoStatistics = mutableListOf<LottoRank>()

        req.lottoTickets.forEach {
            lottoStatistics.add(
                getLottoRank(it, req.winningNumber) ?: return@forEach
            )
        }

        return StatisticsResponse(lottoStatistics)
    }

    private fun getLottoRank(lotto: Lotto, winningNumber: Lotto): LottoRank? {
        return when (lotto.numbers.intersect(winningNumber.numbers.toSet()).size) {
            3 -> LottoRank.FIFTH
            4 -> LottoRank.FOURTH
            5 -> LottoRank.THIRD
            6 -> LottoRank.FIRST
            else -> null
        }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
