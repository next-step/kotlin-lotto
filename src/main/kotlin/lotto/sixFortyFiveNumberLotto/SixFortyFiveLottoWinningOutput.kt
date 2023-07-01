package lotto.sixFortyFiveNumberLotto

data class SixFortyFiveLottoWinningOutput(
    private val lottoes: SixFortyFiveLottoes,
    private val winningValue: SixFortyFiveWinningLotto,
) {
    private val winningResultEnumList: List<SixFortyFiveWinningEnum> = lottoes.getWinningResultEnumList(winningValue)
    val winningResultEnumMap: Map<SixFortyFiveWinningEnum, Int>
    val earningRate: Double

    init {
        winningResultEnumMap = convertWinningResultEnumListToMap()
        earningRate = calcEarningRate()
    }

    private fun convertWinningResultEnumListToMap(): MutableMap<SixFortyFiveWinningEnum, Int> {
        val lottoWinningEnumPairs = SixFortyFiveWinningEnum.values().map { it to 0 }.toTypedArray()
        val winningResultEnumMap = mutableMapOf(*lottoWinningEnumPairs)
        winningResultEnumList.map { winningResultEnum ->
            winningResultEnumMap[winningResultEnum] = winningResultEnumMap[winningResultEnum]!!.plus(1)
        }
        return winningResultEnumMap
    }

    private fun calcEarningRate(): Double {
        val totalResultPrice = winningResultEnumList.map { it.price }.reduce { acc, count -> acc + count }
        val totalPurchasePrice = lottoes.getCount().value * SixFortyFiveLotto.LOTTO_PRICE
        return totalResultPrice / totalPurchasePrice.toDouble()
    }
}
