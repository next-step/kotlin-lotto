package lottery.domain

class DrawResult(private val rankRewardLotteryCountMap: Map<RankReward, LotteryCount>) {
    fun getProfitRate(purchaseAmount: Money): Double {
        return getTotalReward() / purchaseAmount
    }

    fun findLotteryCount(rankReward: RankReward): LotteryCount {
        return rankRewardLotteryCountMap[rankReward] ?: LotteryCount(0)
    }

    private fun getTotalReward(): Money {
        return rankRewardLotteryCountMap.entries.fold(Money.ZERO) { total: Money, (rankReward: RankReward, lotteryCount: LotteryCount) ->
            val totalRewardPerRank: Money = rankReward.money * lotteryCount.count
            total + totalRewardPerRank
        }
    }

    companion object {
        fun from(
            winningLottery: WinningLottery,
            purchaseLotteries: List<Lottery>,
        ): DrawResult {
            val rankRewardLotteryCountMap =
                purchaseLotteries
                    .mapNotNull { lottery ->
                        val matchedNumberCount = winningLottery.countMatchedNumber(lottery)
                        RankReward.fromMatchedNumberCount(matchedNumberCount)
                    }
                    .groupingBy { it }
                    .eachCount()
                    .mapValues { LotteryCount(it.value) }
            return DrawResult(rankRewardLotteryCountMap)
        }
    }
}
