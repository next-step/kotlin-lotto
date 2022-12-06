package lotto.controller.dto

class WinningStatistic(winningPrizeInfo: List<WinningPrizeInfo>, statisticOfMatchedCount: Map<Int, Int>) {
    val winningStatistic: List<Pair<WinningPrizeInfo, WinningPrizeCount>>

    init {
        winningStatistic = winningPrizeInfo.map {
            Pair(it, WinningPrizeCount(statisticOfMatchedCount.getOrDefault(it.matchedCount, 0)))
        }
    }
}

class WinningPrizeInfo(val matchedCount: Int, val prize: Int, val hasBonus: Boolean = false)

class WinningPrizeCount(val count: Int)
