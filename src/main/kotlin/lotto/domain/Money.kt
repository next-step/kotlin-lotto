package lotto.domain

class Money(
    private val purchaseFee: Int = 0,
    private var revenueRate: Double = 0.0
) {
    fun getPurchaseFee() = purchaseFee
    fun getRevenueRate(matchInfo: MatchInfo) = matchInfo.getRevenueFee() / purchaseFee.toDouble()
}
