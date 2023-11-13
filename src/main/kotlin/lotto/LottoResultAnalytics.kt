package lotto

class LottoResultAnalytics(private val winningLotto: WinningLotto, val lottoTickets: LottoTickets) {
    private val rankingsCount: Map<LottoRanking, Int> = lottoTickets.values
        .map { winningLotto.checkRanking(it) }
        .groupingBy { it }
        .eachCount()

    fun calculateWinningStatistics(): Map<LottoRanking, Int> {
        return LottoRanking.values().associateWith {
            rankingsCount.get(it) ?: 0
        }
    }

    fun calculateProfitRate(): Double {
        val totalInvestment = lottoTickets.values.size * LottoGame.LOTTO_PRICE
        val totalPrize = LottoRanking.values().sumOf { ranking ->
            (rankingsCount[ranking] ?: 0) * ranking.prize
        }

        return String.format("%.2f", totalPrize.toDouble() / totalInvestment).toDouble()
    }
}
