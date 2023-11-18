package lotto2.application

import lotto2.domain.LottoRanking

object LottoResultAnalyticsApplication {

    fun getWinningStatistics(rankingsCount: Map<LottoRanking, Int>): Map<LottoRanking, Int> {
        return LottoRanking.values().associateWith {
            rankingsCount[it] ?: 0
        }
    }

    fun getProfitRate(rankingsCount: Map<LottoRanking, Int>, totalInvestment: Int): Double {
        val totalPrize = LottoRanking.values().sumOf { ranking ->
            (rankingsCount[ranking] ?: 0) * ranking.prize
        }

        return totalPrize.toDouble() / totalInvestment.toDouble()
    }
}
