package lotto.domain

class WinnerStat(
    private val purchaseRecord: PurchaseRecord,
    private val winnerNumbers: List<LottoNumber>
) {
    val winnerMap: Map<Winner, Int>

    init {
        winnerMap = purchaseRecord
            .lottoList
            .map { lotto -> getWinner(lotto, winnerNumbers) }
            .filterNotNull()
            .groupingBy { it }
            .eachCount()
    }

    fun per(): Double {
        val price = purchaseRecord.lottoList.size * LottoShop.LOTTO_PRICE
        val earning = winnerMap.map { e -> e.key.prizeMonery * e.value }.sum()
        return earning / price.toDouble()
    }

    private fun getWinner(lotto: Lotto, winnerNumbers: List<LottoNumber>): Winner? {
        return Winner.values()
            .find { it.matchedNumbers == getMatchedNumbers(lotto, winnerNumbers) }
    }

    private fun getMatchedNumbers(lotto: Lotto, winnerNumbers: List<LottoNumber>): Int {
        return winnerNumbers
            .filter { lotto.contains(it) }
            .count()
    }
}
