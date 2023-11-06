package lotto.business

class LotteryStatisticsGenerator {
    fun calculateProfitRate(receivedAmount: ReceivedAmount, prizeResults: PrizeResults): ProfitRate {
        val totalPrize = prizeResults.prizeCountMap.map { it.key.prizeAmount * it.value }.sum()
        return ProfitRate(totalPrize / receivedAmount.amount.toDouble())
    }
}
