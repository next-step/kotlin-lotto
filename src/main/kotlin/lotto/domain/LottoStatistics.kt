package lotto.domain

class LottoStatistics(
    val totalPurchaseAmount: Int,
    val ranks: List<Rank>,
    val totalReward: Long,
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

    fun getYield(): Double {
        return totalReward.toDouble() / totalPurchaseAmount
    }
}
