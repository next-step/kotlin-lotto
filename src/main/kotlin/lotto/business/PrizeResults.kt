package lotto.business

class PrizeResults(prizeCountMap: Map<LotteryPrize, Int>) {

    private val _prizeCountMap = prizeCountMap.toMutableMap()

    val prizeCountMap: Map<LotteryPrize, Int>
        get() {
            return LotteryPrize.values().associateWith {
                _prizeCountMap.getOrDefault(it, 0)
            }
        }

    fun calculateProfitRate(receivedAmount: ReceivedAmount): ProfitRate {
        val totalPrize = prizeCountMap.map { it.key.prizeAmount * it.value }.sum()
        return ProfitRate(totalPrize / receivedAmount.amount.toDouble())
    }
}
