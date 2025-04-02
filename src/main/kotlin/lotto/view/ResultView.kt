package lotto.view

import lotto.Lotto
import lotto.Rank
import lotto.WinningStatistics

class ResultView {
    fun printWinningStatistics(winningStatistics: WinningStatistics) {
        println(GUIDE_STATISTICS)
        Rank.entries.forEach { rank ->
            val count = winningStatistics.countBy(rank)
            println(GUIDE_RANK_INFO.format(rank.prize, count))
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
        private const val GUIDE_RANK_INFO = "Matches (%d KRW) - %d Tickets"
        private const val GUIDE_STATISTICS = "Winning Statistics \n------------------"
    }
}
