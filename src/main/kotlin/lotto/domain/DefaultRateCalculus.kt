package lotto.domain

import kotlin.math.floor

class DefaultRateCalculus: RateCalculus {

    override fun calc(number1: Double, number2: Double): Double =
        dropDecimalPoint(number1, number2)

    private val dropDecimalPoint: (Double, Double) -> Double =
        {sum, money -> floor((sum / money) * 100) / 100.0 }
}
