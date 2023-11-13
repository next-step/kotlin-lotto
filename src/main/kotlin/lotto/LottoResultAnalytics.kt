package lotto

class LottoResultAnalytics(private val winningLotto: WinningLotto, private val lottoTickets: LottoTickets) {

    fun calculateWinningStatistics(): Map<LottoRanking, Int> {
        val rankingsCount = lottoTickets.values
            .map { winningLotto.checkRanking(it) }
            .groupingBy { it }
            .eachCount()

        return LottoRanking.values().associateWith {
            rankingsCount.get(it) ?: 0
        }
    }
}
