package lotto.business

class PrizeResults(val prizeCountMap: Map<LotteryPrize, Int>) {
    fun calculateProfitRate(receivedAmount: ReceivedAmount): ProfitRate {
        val totalPrize = prizeCountMap.map { it.key.prizeAmount * it.value }.sum()
        return ProfitRate(totalPrize / receivedAmount.amount.toDouble())
    }
}
