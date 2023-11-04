package lotto.business

class PrizeResults(val prizeCountMap: Map<LotteryPrize, Int>){
    fun calculateProfitRate(receivedAmount: ReceivedAmount): Any {
        val totalPrize = prizeCountMap.map { it.key.prizeAmount * it.value }.sum()
        return totalPrize / receivedAmount.amount.toDouble()
    }
}
