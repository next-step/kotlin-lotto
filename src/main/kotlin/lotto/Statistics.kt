package lotto

/**
 * 로또 통계
 */
class Statistics(private val lottoResultList: List<LottoResult>, private val purchasePrice: Int) {
    private val prizeList = LottoResult.Prize.values()

    var totalEarnings = 0.0
        private set

    val items = mutableListOf<StatisticsItem>()

    fun run() {
        prizeList.map { prizeItem ->
            StatisticsItem(
                standardPrize = prizeItem.price,
                prize = prizeItem,
                machLottoCount = lottoResultList.filter { it.machCount == prizeItem.machCount }.size,
            )
        }.sortedBy {
            it.prize.machCount
        }.apply {
            items.addAll(this)
        }

        totalEarnings = lottoResultList.sumOf { it.prize }.let {
            return@let String.format("%.2f", it.toDouble() / purchasePrice.toDouble()).toDouble()
        }
    }
}

data class StatisticsItem(
    val standardPrize: Int,
    val prize: LottoResult.Prize,
    val machLottoCount: Int
)
