package lottery.domain

class LotteryMatcher(private val winnerLottery: WinnerLottery, private val createdLotteries: List<Lottery>) {
    fun match(): RankCounts {
        val rankCounts = RankCounts()

        createdLotteries.map {
            val count = winnerLottery.matchCount(it.lotteryNumbers)

            if (Rank.isInTheRank(count)) {
                rankCounts.addMatchCount(Rank.valueOf(count))
            }
        }

        return rankCounts
    }
}
