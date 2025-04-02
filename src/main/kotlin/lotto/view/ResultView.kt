package lotto.view

import lotto.Lotto
import lotto.Rank
import lotto.WinningStatistics

class ResultView {
    fun printWinningStatistics(winningStatistics: WinningStatistics) {
        Rank.entries.forEach { rank ->
            val count = winningStatistics.countBy(rank)
            println(MESSAGE_RANK_INFO.format(rank.prize, count))
        }
    }

    fun printProfit(profit: Double) {
        println(MESSAGE_PROFIT.format(profit))
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.lottoNumbers.toString())
    }

    companion object {
        private const val MESSAGE_PROFIT = "Total return rate is %d"
        private const val MESSAGE_RANK_INFO = "Matches (%d KRW) - %d Tickets"
    }
}
