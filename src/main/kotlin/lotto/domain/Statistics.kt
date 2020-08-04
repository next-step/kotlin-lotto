package lotto.domain

import kotlin.math.round

object Statistics {

    var count_3 = 0
    var count_4 = 0
    var count_5 = 0
    var count_6 = 0

    fun countRank(winningCount: Int) {
        when (winningCount) {
            3 -> count_3++
            4 -> count_4++
            5 -> count_5++
            6 -> count_6++
        }
    }

    fun winningAmount(): Int {
        return (count_3 * 5000) + (count_4 * 50000) + (count_5 * 1500000) + (count_6 * 2000000000)
    }

    fun calculateRatio(purchaseCount: Int): Double {
        return round(winningAmount().toDouble() * 10 / (purchaseCount * 1000)) / 10
    }
}
