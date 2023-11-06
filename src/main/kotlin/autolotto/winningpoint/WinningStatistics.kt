package autolotto.winningpoint

import autolotto.vo.AutoLotto
import autolotto.vo.WinningLotto

object WinningStatistics {
    private val countMap = mutableMapOf<WinningRank, Int>().withDefault { 0 }

    fun getCount(rank: WinningRank): Int {
        return countMap.getValue(rank)
    }

    fun calculateStatistics(autoLotto: AutoLotto, winningLotto: WinningLotto): WinningStatistics {
        val statistics = this
        autoLotto.lottos.forEach { lotto ->
            val (_, winningRank) = lotto.checkWinning(winningNumbers = winningLotto.numbers)
            statistics.recordWinningRank(winningRank)
        }
        return statistics
    }

    private fun recordWinningRank(rank: WinningRank) {
        countMap[rank] = countMap.getValue(rank) + 1
    }
}
