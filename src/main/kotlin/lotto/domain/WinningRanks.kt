package lotto.domain

import lotto.constants.WinningRank

@JvmInline
value class WinningRanks(val winningRanks: List<WinningRank>) {

    fun calculateRateOfReturn(inputPrice: Int): Double {
        val totalWinningMoney = winningRanks.sumOf { it.money }
        return totalWinningMoney.toDouble() / inputPrice
    }

    fun winningRankGroupBy(): Map<WinningRank, Int> {
        return winningRanks.groupingBy { it }.eachCount()
    }
}
