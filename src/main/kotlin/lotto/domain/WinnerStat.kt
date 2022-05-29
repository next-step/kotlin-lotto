package lotto.domain

class WinnerStat(
    private val purchaseRecord: PurchaseRecord,
    private val winner: Winner
) {
    val winnerTypeMap: Map<WinnerType, Int>

    init {
        winnerTypeMap = purchaseRecord
            .lottoList
            .map { lotto -> getWinnerType(lotto, winner) }
            .filterNotNull()
            .groupingBy { it }
            .eachCount()
    }

    fun per(): Double {
        val price = purchaseRecord.lottoList.size * LottoShop.LOTTO_PRICE
        val earning = winnerTypeMap.map { e -> e.key.prizeMonery * e.value }.sum()
        return earning / price.toDouble()
    }

    private fun getWinnerType(lotto: Lotto, winnerNumbers: Winner): WinnerType? {
        return WinnerType.valueOf(
            getMatchedNumbers(lotto, winnerNumbers.lottoNumbers),
            lotto.contains(winnerNumbers.bonusNumber)
        )
    }

    private fun getMatchedNumbers(lotto: Lotto, winnerNumbers: List<LottoNumber>): Int {
        return winnerNumbers
            .filter { lotto.contains(it) }
            .count()
    }
}
