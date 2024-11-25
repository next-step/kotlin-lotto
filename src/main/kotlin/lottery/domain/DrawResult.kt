package lottery.domain

class DrawResult(private val rankRewardLotteryCountMap: Map<RankReward, LotteryCount>) {
    fun calculateTotalPrize(): Money {
        return rankRewardLotteryCountMap.entries.fold(Money.ZERO) { total, (rankReward, lotteryCount) ->
            val totalRewardPerRank = rankReward.money * lotteryCount.count
            total + totalRewardPerRank
        }
    }

    fun findLotteryCount(rankReward: RankReward): LotteryCount {
        return rankRewardLotteryCountMap[rankReward] ?: LotteryCount(0)
    }

    companion object {
        fun from(
            winningLottery: WinningLottery,
            purchaseLotteries: List<Lottery>,
        ): DrawResult {
            val rankRewardLotteryCountMap =
                purchaseLotteries
                    .mapNotNull { lottery ->
                        val matchedNumberCount = winningLottery.lottery.countMatchedNumber(lottery)
                        RankReward.fromMatchedNumberCount(matchedNumberCount)
                    }
                    .groupingBy { it }
                    .eachCount()
                    .mapValues { LotteryCount(it.value) }
            return DrawResult(rankRewardLotteryCountMap)
        }
    }
}
