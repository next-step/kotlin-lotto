package lotto.result

import kotlin.math.floor

data class Prize(private val prizeAmount: Long) {

    fun calculateYield(investment: Long): Double {
        val yield = prizeAmount.toDouble() / investment

        // 소수점 절삭
        return floor(`yield` * FLOOR_DECIMAL_POINT) / FLOOR_DECIMAL_POINT
    }

    companion object {
        private const val FLOOR_DECIMAL_POINT: Int = 100
    }
}

fun Long.toPrize(): Prize {
    return Prize(this)
}
