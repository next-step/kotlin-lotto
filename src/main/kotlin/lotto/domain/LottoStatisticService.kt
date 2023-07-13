package lotto.domain

import lotto.domain.dto.ProfitRateRequest
import lotto.domain.dto.StatisticsRequest
import kotlin.math.round

class LottoStatisticService {

    fun getStatistics(req: StatisticsRequest): List<LottoRank> {
        return req.lottoTickets.lottoTickets.map { req.winningLotto.getLottoRank(it) }
    }

    fun getProfitRate(req: ProfitRateRequest): Double {
        val totalPrize = req.statistics.sumOf { it.prizeMoney }.toDouble()
        val profitRate = totalPrize.div(req.purchaseAmount.amount.toDouble())
        return round(profitRate * 100) / 100
    }
}
