package lotto

/**
 * 로또 통계
 */
object Statistics {
    private val prizeList = LottoResult.Prize.values()
    fun get(lottoResultList: List<LottoResult>, purchasePrice: Int): List<String> {

        val displayList = prizeList.map { prizeItem ->
            val ownLottoResult = lottoResultList.filter {
                it.machCount == prizeItem.machCount
            }

            return@map "${prizeItem.machCount}개 일치 ${prizeItem.price}원 (${ownLottoResult.size})개"
        }.toMutableList()

        lottoResultList.sumOf { it.prize }.let {
            displayList.add("총 수익률은  ${String.format("%.2f", it.toDouble() / purchasePrice.toDouble())}입니다")
        }

        return displayList.toList()
    }
}
