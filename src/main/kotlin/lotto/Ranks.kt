package lotto

import java.math.RoundingMode

class Ranks(private val ranks: List<Rank>) {

    fun rateOfReturn(payment: Int): Double {
        val totalPrize = ranks.sumOf { it.prize }
        val ratio = (totalPrize.toDouble() / payment)
        return ratio.toBigDecimal().setScale(2, RoundingMode.DOWN).toDouble()
    }
}