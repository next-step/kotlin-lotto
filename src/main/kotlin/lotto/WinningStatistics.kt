package lotto

import kotlin.math.floor

class WinningStatistics(private val price: Int, private val winningResult: HashMap<Const.RANKING, Int>) {

    fun rateOfReturn(): Float {
        return floor(getWinningPrice().toFloat() / price.toFloat() * 100) / 100
    }

    private fun getWinningPrice(): Int {
        var winningPrice = 0

        Const.RANKING.values().forEach { place ->
            val winningCount: Int = winningResult[place] ?: 0
            winningPrice += place.winningPrice * winningCount
        }

        return winningPrice
    }
}
