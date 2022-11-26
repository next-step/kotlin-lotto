package lotto

class WinningStatistics(private val lottoList: List<Lotto>, private val winningNumbers: List<Int>) {

    enum class PLACING(val winningCount: Int, val winningPrice: Int) {
        FOUR_PLACE(3, 5000), THREE_PLACE(4, 50000), TWO_PLACE(5, 1500000), ONE_PLACE(6, 2000000000)
    }

    fun winningCheck(): HashMap<PLACING, Int> {
        val winningResult = HashMap<PLACING, Int>()

        lottoList.forEach { lotto ->
            val union = lotto.publishNumbers + winningNumbers

            when (union.size - union.distinct().size) {
                PLACING.FOUR_PLACE.winningCount -> {
                    setWinningPlaceValue(PLACING.FOUR_PLACE, winningResult)
                }
                PLACING.THREE_PLACE.winningCount -> {
                    setWinningPlaceValue(PLACING.THREE_PLACE, winningResult)
                }
                PLACING.TWO_PLACE.winningCount -> {
                    setWinningPlaceValue(PLACING.TWO_PLACE, winningResult)
                }
                PLACING.ONE_PLACE.winningCount -> {
                    setWinningPlaceValue(PLACING.ONE_PLACE, winningResult)
                }
            }
        }

        return winningResult
    }

    private fun setWinningPlaceValue(place: PLACING, winningResult: HashMap<PLACING, Int>) {
        var winningCount: Int = winningResult[place] ?: 0
        winningResult[place] = ++ winningCount
    }
}
