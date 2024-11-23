package lottery.domain

class DrawResult(val rankRewardLotteryCountMap: Map<RankReward, LotteryCount>) {
    fun calculateTotalPrize(): Money {
        return rankRewardLotteryCountMap.entries.fold(Money(0)) { total, (rankReward, lotteryCount) ->
            total + rankReward.money * lotteryCount.count
        }
    }
}
