package lotto

class LottoResultAnalytics(private val rankingsCount: Map<LottoRanking, Int>) {

    fun getWinningStatistics(): Map<LottoRanking, Int> {
        return LottoRanking.values().associateWith {
            rankingsCount[it] ?: 0
        }
    }

    fun getProfitRate(ticketQuantity: Int): Double {
        val totalInvestment = ticketQuantity * LottoPolicy.LOTTO_PRICE
        val totalPrize = LottoRanking.values().sumOf { ranking ->
            (rankingsCount[ranking] ?: 0) * ranking.prize
        }

        return String.format("%.2f", totalPrize.toDouble() / totalInvestment).toDouble()
    }
}
