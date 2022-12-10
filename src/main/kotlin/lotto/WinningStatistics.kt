package lotto

import kotlin.math.floor

class WinningStatistics(private val price: Int, private val winningResult: HashMap<RANKING, Int>) {

    fun rateOfReturn(): Float {
        return floor(getWinningPrice().toFloat() / price.toFloat() * 100) / 100
    }

    private fun getWinningPrice(): Int {
        var winningPrice = 0

        RANKING.values().forEach { ranking ->
            val winningCount: Int = winningResult[ranking] ?: 0
            winningPrice += ranking.winningPrice * winningCount
        }

        return winningPrice
    }
}
