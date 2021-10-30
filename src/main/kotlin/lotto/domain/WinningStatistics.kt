package lotto.domain

class WinningStatistics(
    private val ranks: List<Rank>,
) {
    fun getFirstRankCount(): Int {
        return ranks.filter { it == Rank.FIRST }.size
    }

    fun getSecondRankCount(): Int {
        return ranks.filter { it == Rank.SECOND }.size
    }

    fun getThirdRankCount(): Int {
        return ranks.filter { it == Rank.THIRD }.size
    }

    fun getFourthRankCount(): Int {
        return ranks.filter { it == Rank.FOURTH }.size
    }

    fun getTotalReward(): Double {
        return ranks.sumOf { rank -> rank.reward }.toDouble()
    }
}
