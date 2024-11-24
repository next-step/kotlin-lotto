package lottery.domain

class WinningLottery(val lottery: Lottery) {
    fun draw(lotteries: List<Lottery>): DrawResult {
        val rankRewardLotteryCountMap =
            lotteries
                .mapNotNull { lottery ->
                    val matchedNumberCount = this.lottery.countMatchedNumber(lottery)
                    RankReward.fromMatchedNumberCount(matchedNumberCount)
                }
                .groupingBy { it }
                .eachCount()
                .mapValues { LotteryCount(it.value) }
        return DrawResult(rankRewardLotteryCountMap)
    }

    companion object {
        fun create(numbers: List<Int>): WinningLottery {
            return WinningLottery(Lottery(LotteryNumbers(numbers.toSet())))
        }
    }
}
