package lottery.domain

class WinningTicket(val lottery: Lottery) {
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
}
