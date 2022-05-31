package lotto.domain

class WinnerStat(
    private val purchaseRecord: PurchaseRecord,
    winner: Winner
) {
    val winnerTypeMap: Map<WinnerType, Int> = purchaseRecord
        .findWinnerTypes(winner)
        .groupingBy { it }
        .eachCount()

    fun per(): Double {
        val price = purchaseRecord.lottoList.size * Lotto.LOTTO_PRICE
        val earning = winnerTypeMap.map { e -> e.key.prizeMonery * e.value }.sum()
        return earning / price.toDouble()
    }
}
