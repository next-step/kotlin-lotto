package lotto.business

class LotteryStatisticsGenerator {
    fun generateStatistics(prizeResults: PrizeResults): LotteryStatistics {
        val treeMatchCount = prizeResults.prizeCountMap[LotteryPrize.THREE_MATCH] ?: 0
        val fourMatchCount = prizeResults.prizeCountMap[LotteryPrize.FOUR_MATCH] ?: 0
        val fiveMatchCount = prizeResults.prizeCountMap[LotteryPrize.FIVE_MATCH] ?: 0
        val sixMatchCount = prizeResults.prizeCountMap[LotteryPrize.SIX_MATCH] ?: 0
        return LotteryStatistics(treeMatchCount, fourMatchCount, fiveMatchCount, sixMatchCount)
    }
}
