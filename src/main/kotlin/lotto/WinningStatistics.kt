package lotto

import kotlin.math.floor

class WinningStatistics(private val lottoList: List<Lotto>, private val winningNumbers: List<Int>) {

    private val winningResult = HashMap<RANKING, Int>()

    enum class RANKING(val winningCount: Int, val winningPrice: Int) {
        FOURTH(3, 5000), THIRD(4, 50000), SECOND(5, 1500000), FIRST(6, 2000000000)
    }

    fun winningCheck(): HashMap<RANKING, Int> {
        winningResult.clear()

        lottoList.forEach { lotto ->
            val union = lotto.publishNumbers + winningNumbers

            when (union.size - union.distinct().size) {
                RANKING.FOURTH.winningCount -> {
                    setWinningPlaceValue(RANKING.FOURTH)
                }
                RANKING.THIRD.winningCount -> {
                    setWinningPlaceValue(RANKING.THIRD)
                }
                RANKING.SECOND.winningCount -> {
                    setWinningPlaceValue(RANKING.SECOND)
                }
                RANKING.FIRST.winningCount -> {
                    setWinningPlaceValue(RANKING.FIRST)
                }
            }
        }

        return winningResult
    }

    private fun setWinningPlaceValue(place: RANKING) {
        var winningCount: Int = winningResult[place] ?: 0
        winningResult[place] = ++ winningCount
    }

    fun rateOfReturn(): Float {
        val purchasePrice = lottoList.size * Const.LOTTO_BASE_PRICE
        return floor(getWinningPrice().toFloat() / purchasePrice.toFloat() * 100) / 100
    }

    private fun getWinningPrice(): Int {
        var winningPrice = 0

        RANKING.values().forEach { place ->
            val winningCount: Int = winningResult[place] ?: 0
            winningPrice += place.winningPrice * winningCount
        }

        return winningPrice
    }
}
