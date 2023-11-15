package lotto

class LottoResultAnalytics(private val winningLotto: WinningLotto, private val lottoTickets: LottoTickets) {
    private val rankingsCount: Map<LottoRanking, Int> = lottoTickets.values
        .map { winningLotto.checkRanking(it) }
        .groupingBy { it }
        .eachCount()

    fun calculateWinningStatistics(): Map<LottoRanking, Int> {
        return LottoRanking.values().associateWith {
            rankingsCount[it] ?: 0
        }
    }

    fun calculateProfitRate(): Double {
        val totalInvestment = lottoTickets.values.size * LottoPolicy.LOTTO_PRICE
        val totalPrize = LottoRanking.values().sumOf { ranking ->
            (rankingsCount[ranking] ?: 0) * ranking.prize
        }

        return String.format("%.2f", totalPrize.toDouble() / totalInvestment).toDouble()
    }
}
