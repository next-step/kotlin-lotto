package lottery.domain

class DrawResult(private val rankRewardLotteryCountMap: Map<RankReward, LotteryCount>) {
    fun calculateTotalPrize(): Money {
        val initial = Money.ZERO
        return rankRewardLotteryCountMap.entries.fold(initial) { total, (rankReward, lotteryCount) ->
            val rewardPerRank = rankReward.money * lotteryCount.count
            total + rewardPerRank
        }
    }

    fun findLotteryCount(rankReward: RankReward): LotteryCount {
        return rankRewardLotteryCountMap[rankReward] ?: LotteryCount(0)
    }
}
