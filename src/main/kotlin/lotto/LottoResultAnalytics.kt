package lotto

class LottoResultAnalytics(private val rankingsCount: Map<LottoRanking, Int>) {

    fun getWinningStatistics(): Map<LottoRanking, Int> {
        return LottoRanking.values().associateWith {
            rankingsCount[it] ?: 0
        }
    }

    fun getProfitRate(totalInvestment: Int): Double {
        val totalPrize = LottoRanking.values().sumOf { ranking ->
            (rankingsCount[ranking] ?: 0) * ranking.prize
        }

        return String.format("%.2f", totalPrize.toDouble() / totalInvestment).toDouble()
    }
}
