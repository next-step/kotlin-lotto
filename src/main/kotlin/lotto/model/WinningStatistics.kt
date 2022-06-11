package lotto.model

import java.util.EnumMap
import kotlin.math.floor

class WinningStatistics private constructor(
    val winningStatistics: EnumMap<WinningRank, Int>
) {

    fun calculateEarningRatio(paymentPrice: Int): Double {
        val earnings = winningStatistics.keys.sumOf { it.prizeMoney * (winningStatistics[it] ?: 0) }
        return floor(earnings / paymentPrice.toDouble() * 100.0) / 100
    }

    companion object {
        fun from(winningRanks: List<WinningRank>): WinningStatistics {
            return WinningRank.values().filter { it.isPrize() }
                .reversed()
                .associateWith { rank -> winningRanks.count { rank == it } }
                .toMap(EnumMap(WinningRank::class.java))
                .let(::WinningStatistics)
        }
    }
}
