package step2Lotto.domain

import step2Lotto.domain.dto.Lotto
import step2Lotto.domain.dto.LottoRank
import step2Lotto.domain.dto.StatisticsRequest
import kotlin.math.round

class LottoService(
    private val lottoGenerator: LottoGenerator
) {
    fun getLottoTicketQuantity(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    fun purchaseLottoTickets(lottoTicketQuantity: Int): List<Lotto> {
        return List(lottoTicketQuantity) { lottoGenerator.execute() }
    }

    fun getStatistics(req: StatisticsRequest): List<LottoRank> {
        return req.lottoTickets.map { getLottoRank(it, req.winningNumber) }
    }

    private fun getLottoRank(lotto: Lotto, winningNumber: Lotto): LottoRank {
        return when (lotto.numbers.intersect(winningNumber.numbers.toSet()).size) {
            3 -> LottoRank.FIFTH
            4 -> LottoRank.FOURTH
            5 -> LottoRank.THIRD
            6 -> LottoRank.FIRST
            else -> LottoRank.LOSE
        }
    }

    fun getProfitRate(purchaseAmount: Int, statistics: List<LottoRank>): Double {
        val totalPrize = statistics.sumOf { it.prizeMoney }.toDouble()
        val profitRate = totalPrize.div(purchaseAmount.toDouble())
        return round(profitRate * 100) / 100
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
