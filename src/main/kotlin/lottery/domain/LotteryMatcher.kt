package lottery.domain

class LotteryMatcher(
    private val winnerLottery: WinnerLottery,
    private val createdLotteries: List<Lottery>
) {
    fun match(bonusBall: Int): RankCounts {
        val rankCounts = RankCounts()

        createdLotteries.map {
            val count = winnerLottery.matchCount(it.lotteryNumbers)
            val hasBonus = it.lotteryNumbers.contains(bonusBall)


            if (Rank.isInTheRank(count, hasBonus)) {
                rankCounts.addMatchCount(Rank.valueOf(count, hasBonus))
            }
        }

        return rankCounts
    }
}
