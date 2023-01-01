package lotto.domain

import kotlin.math.floor

class WinningStatistics(private val price: Int) {

    fun rateOfReturn(winningPrice: Int): Float {
        return floor(winningPrice.toFloat() / price.toFloat() * 100) / 100
    }
}
