package lotto.domain

class LottoStatistics(
    val totalPurchaseAmount: Int,
    val firstRank: Int,
    val secondRank: Int,
    val thirdRank: Int,
    val fourthRank: Int,
    val totalReward: Long,
) {

    fun getYield(): Double {
        return totalReward.toDouble() / totalPurchaseAmount
    }
}
