package lotto.domain

class Money(
    private val purchaseFee: Int = 0,
    private var revenueRate: Double = 0.0
) {
    fun getPurchaseFee() = purchaseFee
    fun getRevenueRate() = revenueRate
    fun setRevenueRate(matchInfo: Map<Reward, Int>) {
        revenueRate =
            matchInfo.toList().sumOf { it.first.name.toInt() * it.first.count * it.second } / purchaseFee.toDouble()
    }
}
