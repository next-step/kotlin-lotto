package lotto.domain

class Rank(val matchReward: Map<Reward, Int>) {

    fun getIncomeRate(purchaseCount: Int): Double =
        matchReward.map { (reward, resultCount) -> reward.amount * resultCount }
            .sum()
            .toDouble()
            .div(purchaseCount * Lotto.PRICE)
}
