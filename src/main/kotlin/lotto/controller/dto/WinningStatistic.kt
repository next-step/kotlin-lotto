package lotto.controller.dto

data class WinningStatistic(private val allWinningPrizes: List<WinningPrizeInfo>, private val statisticOfWinningPrize: Map<WinningPrizeInfo, Int>) {
    val winningStatistic: Map<WinningPrizeInfo, WinningPrizeCount> = allWinningPrizes.associateWith { WinningPrizeCount(statisticOfWinningPrize[it] ?: 0) }
}

data class WinningPrizeInfo(val matchedCount: Int, val prize: Int, val hasBonus: Boolean = false)

data class WinningPrizeCount(val count: Int)
