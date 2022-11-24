package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {

    fun buyLotto(amount: Int): List<Lotto> {
        require(amount >= LOTTO_PRICE)

        val lottoCount = amount / LOTTO_PRICE

        return (1..lottoCount).map { lottoGenerator.generateLotto() }
    }

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
            .div(purchaseCount * LOTTO_PRICE)

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
