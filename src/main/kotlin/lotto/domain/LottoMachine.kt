package lotto.domain

object LottoMachine : LottoGenerator {
    private const val LOTTO_PRICE = 1_000

    fun getLottoList(amount: Int): List<Lotto> {
        require(amount >= LOTTO_PRICE)

        val lottoCount = amount / LOTTO_PRICE

        return (1..lottoCount).map { generateLotto() }
    }

    private fun generateLotto(): Lotto {
        val lottoNumbers = LottoNumber.NUMBERS
            .keys
            .shuffled()
            .take(Lotto.COUNT)

        return generateLotto(lottoNumbers)
    }

    override fun generateLotto(numbers: List<Int>): Lotto {
        val lottoNumbers = numbers.map { number -> LottoNumber.from(number) }
            .toSet()

        return Lotto(lottoNumbers)
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
}
