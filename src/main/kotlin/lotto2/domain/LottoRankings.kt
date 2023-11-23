package lotto2.domain

class LottoRankings(private val rankings: Map<LottoRanking, Int>) {

    fun getWinningStatistics(): Map<LottoRanking, Int> {
        return LottoRanking.values().associateWith {
            rankings[it] ?: 0
        }
    }

    fun getProfitRate(totalInvestment: Int): Double {
        val totalPrize = LottoRanking.values().sumOf { ranking ->
            (rankings[ranking] ?: 0) * ranking.prize
        }

        return totalPrize.toDouble() / totalInvestment.toDouble()
    }
}
