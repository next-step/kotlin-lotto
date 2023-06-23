package lotto

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(val map: Map<Int, Int>) {
    fun calculateProfitRate(purchaseAmount: Int): Double {
        val profitRate = getTotalPrize() / purchaseAmount.toDouble()
        return BigDecimal(profitRate).setScale(SCALE, RoundingMode.DOWN).toDouble()
    }

    private fun getTotalPrize(): Int {
        var total = 0
        for ((num, price) in WINNING_TABLE) {
            map[num]?.let { total += it * price }
        }
        return total
    }


    companion object {
        const val SCALE = 2
        val WINNING_TABLE = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000
        )
    }
}