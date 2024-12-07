package lotto.util

import kotlin.math.pow
import kotlin.math.roundToLong

object MathCalculator {
    fun calculateRatio(
        numerator: Double,
        denominator: Double,
        decimalPlaces: Int,
    ): Double {
        require(denominator != 0.0) { "분모는 0이 될 수 없습니다." }
        require(decimalPlaces >= 0) { "소수점 자릿수는 0 이상이어야 합니다." }

        val ratio = numerator / denominator
        val multiplier = 10.0.pow(decimalPlaces)
        return (ratio * multiplier).roundToLong() / multiplier
    }
}
