package lotto.business

class LotteryStatisticsGenerator {
    fun generateStatistics(calculatedResults: Map<LotteryPrize, Int>): LotteryStatistics {
        val treeMatchCount = calculatedResults[LotteryPrize.THREE_MATCH] ?: 0
        val fourMatchCount = calculatedResults[LotteryPrize.FOUR_MATCH] ?: 0
        val fiveMatchCount = calculatedResults[LotteryPrize.FIVE_MATCH] ?: 0
        val sixMatchCount = calculatedResults[LotteryPrize.SIX_MATCH] ?: 0
        return LotteryStatistics(treeMatchCount, fourMatchCount, fiveMatchCount, sixMatchCount)
    }
}
