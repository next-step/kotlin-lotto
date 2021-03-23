package lottery.domain

class LotteryMatcher(
    private val winnerLottery: WinnerLottery,
    private val createdLotteries: List<Lottery>
) {
    fun match(bonusBall: BonusBall): RankCounts {
        var rankCounts = RankCounts()

        createdLotteries.map {
            val count = winnerLottery.matchCount(it.lotteryNumbers)
            val hasBonus = it.hasBonusBall(bonusBall)

            rankCounts = addMatchCountWhenInTheRank(count, hasBonus, rankCounts)
        }

        return rankCounts
    }

    private fun addMatchCountWhenInTheRank(
        count: Int,
        hasBonus: Boolean,
        rankCounts: RankCounts
    ): RankCounts {
        if (Rank.isInTheRank(count, hasBonus)) {
            rankCounts.addMatchCount(Rank.valueOf(count, hasBonus))
        }

        return rankCounts
    }
}
