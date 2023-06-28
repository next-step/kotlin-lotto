package Lotto.domain

import Lotto.domain.dto.ProfitRateRequest
import Lotto.domain.dto.StatisticsRequest
import kotlin.math.round

class LottoStatisticService {

    fun getStatistics(req: StatisticsRequest): List<LottoRank> {
        return req.lottoTickets.map { req.winningLotto.getLottoRank(it) }
    }

    fun getProfitRate(req: ProfitRateRequest): Double {
        val totalPrize = req.statistics.sumOf { it.prizeMoney }.toDouble()
        val profitRate = totalPrize.div(req.purchaseAmount.toDouble())
        return round(profitRate * 100) / 100
    }
}
