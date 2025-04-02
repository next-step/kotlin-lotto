package lotto.view

import lotto.Lotto
import lotto.Rank
import lotto.WinningStatistics

class ResultView {
    fun printWinningStatistics(winningStatistics: WinningStatistics) {
        println(GUIDE_STATISTICS)
        Rank.entries.reversed().forEach { rank ->
            printLottoResult(rank, winningStatistics.countBy(rank))
        }
    }

    private fun printLottoResult(
        rank: Rank,
        count: Int,
    ) {
        if (rank != Rank.MISS) {
            println(GUIDE_RANK_INFO.format(rank.matchCount, rank.prize, count))
        }
    }

    fun printProfit(profit: Double) {
        println(GUIDE_PROFIT.format(profit))
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.lottoNumbers.map { it.value }.sorted())
    }

    companion object {
        private const val GUIDE_PROFIT = "Total return rate is %f"
        private const val GUIDE_RANK_INFO = "%d Matches (%,d KRW) - %d Tickets"
        private const val GUIDE_STATISTICS = "Winning Statistics \n------------------"
    }
}
