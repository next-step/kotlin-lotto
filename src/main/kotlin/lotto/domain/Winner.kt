package lotto.domain

object Winner {

    fun match(lottoList: List<Lotto>, winningLotto: Lotto): Map<Reward, Int> {
        val matchToCount: Map<Int, Int> = lottoList
            .groupingBy { lotto -> winningLotto.match(lotto).size }
            .eachCount()

        return Reward.values().associateWith { reward ->
            val resultCount = matchToCount[reward.matchCount] ?: 0

            resultCount
        }
    }

    fun getIncomeRate(purchaseCount: Int, matchReward: Map<Reward, Int>): Double =
        matchReward.map { (reward, resultCount) -> reward.amount * resultCount }
            .sum()
            .toDouble()
            .div(purchaseCount * Lotto.PRICE)
}
