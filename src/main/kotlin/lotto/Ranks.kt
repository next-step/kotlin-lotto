package lotto

import kotlin.math.roundToInt

@JvmInline
value class Ranks(val ranks: List<Rank>) {
    fun calculateEarningRate(boughtPrice: Int): Double {
        val winningPrice = ranks.sumOf { it.winningPrice }.toFloat()
        return (winningPrice / boughtPrice * 100.0).roundToInt() / 100.0
    }
}
