package lotto.business

class PrizeResults(prizeCountMap: Map<LotteryPrize, Int>) {

    private val _prizeCountMap: Map<LotteryPrize, Int> = prizeCountMap.toMap()

    val prizeCountMap: Map<LotteryPrize, Int>
        get() {
            return LotteryPrize.values().associateWith {
                _prizeCountMap[it] ?: 0
            }
        }

    fun calculateProfitRate(receivedAmount: ReceivedAmount): ProfitRate {
        val totalPrize = _prizeCountMap.map { it.key.prizeAmount * it.value }.sum()
        return ProfitRate(totalPrize / receivedAmount.amount.toDouble())
    }
}
