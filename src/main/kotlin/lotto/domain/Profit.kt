package lotto.domain

import kotlin.math.round

class Profit(private val profit: Double, private val payment: Double) {
    val yields: Double
        get() = (round(profit / payment * 100)) / 100
}
