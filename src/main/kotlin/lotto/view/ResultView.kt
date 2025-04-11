package lotto.view

import lotto.Lotto
import lotto.Order
import lotto.Rank
import lotto.WinningStatistics

class ResultView {
    fun printWinningStatistics(
        amount: Int,
        winningStatistics: WinningStatistics,
    ) {
        println(GUIDE_STATISTICS)
        Rank.entries.reversed().forEach { rank ->
            printLottoResult(rank, winningStatistics.countBy(rank))
        }
        printProfit(winningStatistics.calculateProfit(amount))
    }

    private fun printLottoResult(
        rank: Rank,
        count: Int,
    ) {
        if (rank != Rank.MISS) {
            val bonusText = if (rank == Rank.SECOND) GUIDE_MATCH_BONUS else ""
            println(GUIDE_RANK_INFO.format(rank.matchCount, bonusText, rank.prize, count))
        }
    }

    private fun printProfit(profit: Double) {
        println(GUIDE_PROFIT.format(profit))
    }

    fun printLottos(
        order: Order,
        lottos: List<Lotto>,
    ) {
        println(GUIDE_LOTTO_NUMBERS.format(order.manualTicketNumber, order.autoTicketNumber))
        lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.lottoNumbers.map { it.value }.sorted())
    }

    companion object {
        private const val GUIDE_PROFIT = "Total return rate is %f"
        private const val GUIDE_RANK_INFO = "%d Matches%s (%,d KRW) - %d Tickets"
        private const val GUIDE_STATISTICS = "Winning Statistics \n------------------"
        private const val GUIDE_MATCH_BONUS = " + Bonus Ball"
        private const val GUIDE_LOTTO_NUMBERS = "Purchased %d manual and %d automatic tickets"
    }
}
