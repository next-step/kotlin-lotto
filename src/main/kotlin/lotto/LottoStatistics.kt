package lotto

import kotlin.math.round

class LottoStatistics(private val money: Int, results: Map<Winning, Int>) {
    var totalAmount: Double = 0.0

    init {
        results.forEach { (winning, winningCount) ->
            totalAmount += winning.winningAmount * winningCount
        }
    }

    fun getYield(): Double = round(totalAmount / money * DISPLAY_SECOND_DIGIT) / DISPLAY_SECOND_DIGIT

    companion object {
        private const val DISPLAY_SECOND_DIGIT = 100
    }
}
