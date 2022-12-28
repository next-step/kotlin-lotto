package lotto

import kotlin.math.roundToInt

object LottoEarningRate {

    fun calculateEarningRate(boughtPrice: Int, ranks: List<Rank>): Double {
        val winningPrice = ranks.sumOf { it.winningPrice }.toFloat()
        return (winningPrice / boughtPrice * 100.0).roundToInt() / 100.0
    }
}
