package lottery.domain

class LotteryMatcher(
    private val winnerLottery: WinnerLottery,
    private val createdLotteries: List<Lottery>
) {
    fun match(bonusBall: BonusBall): RankCounts {
        val rankCounts = RankCounts()

        createdLotteries.map {
            val count = winnerLottery.matchCount(it.lotteryNumbers)
            val hasBonus = it.hasBonusBall(bonusBall)

            addMatchCountWhenInTheRank(count, hasBonus, rankCounts)
        }

        return rankCounts
    }

    private fun addMatchCountWhenInTheRank(
        count: Int,
        hasBonus: Boolean,
        rankCounts: RankCounts
    ) {
        if (Rank.isInTheRank(count, hasBonus)) {
            rankCounts.addMatchCount(Rank.valueOf(count, hasBonus))
        }
    }
}
