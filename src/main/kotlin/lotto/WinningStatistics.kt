package lotto

import lotto.LottoMachine.Companion.LOTTO_BASE_PRICE

class WinningStatistics(private val lottoList: List<Lotto>, private val winningNumbers: List<Int>) {

    private val winningResult = HashMap<PLACING, Int>()

    enum class PLACING(val winningCount: Int, val winningPrice: Int) {
        FOUR_PLACE(3, 5000), THREE_PLACE(4, 50000), TWO_PLACE(5, 1500000), ONE_PLACE(6, 2000000000)
    }

    fun winningCheck(): HashMap<PLACING, Int> {
        winningResult.clear()

        lottoList.forEach { lotto ->
            val union = lotto.publishNumbers + winningNumbers

            when (union.size - union.distinct().size) {
                PLACING.FOUR_PLACE.winningCount -> {
                    setWinningPlaceValue(PLACING.FOUR_PLACE)
                }
                PLACING.THREE_PLACE.winningCount -> {
                    setWinningPlaceValue(PLACING.THREE_PLACE)
                }
                PLACING.TWO_PLACE.winningCount -> {
                    setWinningPlaceValue(PLACING.TWO_PLACE)
                }
                PLACING.ONE_PLACE.winningCount -> {
                    setWinningPlaceValue(PLACING.ONE_PLACE)
                }
            }
        }

        return winningResult
    }

    private fun setWinningPlaceValue(place: PLACING) {
        var winningCount: Int = winningResult[place] ?: 0
        winningResult[place] = ++ winningCount
    }

    fun rateOfReturn(): Float {
        val purchasePrice = lottoList.size * LOTTO_BASE_PRICE
        return getWinningPrice().toFloat() / purchasePrice.toFloat()
    }

    private fun getWinningPrice(): Int {
        var winningPrice = 0

        PLACING.values().forEach { place ->
            val winningCount: Int = winningResult[place] ?: 0
            winningPrice += place.winningPrice * winningCount
        }

        return winningPrice
    }
}
