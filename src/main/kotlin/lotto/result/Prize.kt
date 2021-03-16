package lotto.result

import kotlin.math.floor

data class Prize(private val prizeAmount: Long) {

    operator fun times(count: Int): Prize {
        return this.copy(prizeAmount = this.prizeAmount * count)
    }

    operator fun plus(prize: Prize): Prize {
        return this.copy(prizeAmount = this.prizeAmount + prize.prizeAmount)
    }

    fun calculateYield(investment: Int): Double {
        val yield = prizeAmount.toDouble() / investment

        //소수점 절삭
        return floor(`yield` * FLOOR_DECIMAL_POINT) / FLOOR_DECIMAL_POINT
    }

    companion object {
        val FLOOR_DECIMAL_POINT: Int = 100
    }
}