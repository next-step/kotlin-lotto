package step2Lotto.domain

import step2Lotto.domain.dto.ProfitRateRequest
import step2Lotto.domain.dto.StatisticsRequest
import kotlin.math.round

class LottoService {

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

    fun getProfitRate(req: ProfitRateRequest): Double {
        val totalPrize = req.statistics.sumOf { it.prizeMoney }.toDouble()
        val profitRate = totalPrize.div(req.purchaseAmount.toDouble())
        return round(profitRate * 100) / 100
    }
}
