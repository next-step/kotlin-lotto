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

    companion object {
        fun from(
            winningLottery: WinningLottery,
            lotteries: List<Lottery>,
        ): DrawResult {
            val rankRewardLotteryCountMap =
                lotteries
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
