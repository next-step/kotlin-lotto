package lotto.domain

class WinnerStat(private val purchaseRecord: PurchaseRecord, winnerNumbers: WinnerNumbers) {
    val winnerMap: Map<Winner, Int> = purchaseRecord
        .findWinners(winnerNumbers)
        .groupingBy { it }
        .eachCount()

    fun per(): Double {
        val price = purchaseRecord.lottoList.size * LottoShop.LOTTO_PRICE
        val earning = winnerMap.map { e -> e.key.prizeMonery * e.value }.sum()
        return earning / price.toDouble()
    }
}
