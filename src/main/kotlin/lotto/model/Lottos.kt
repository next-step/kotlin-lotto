package lotto.model

class Lottos(val allLottos: List<Lotto>) {
    constructor(count: Int) : this(createLottos(count))

    fun check(winningNumbers: List<Int>, checkCount: Int): Int {
        return allLottos
            .map { it.getWinningCount(Lotto(winningNumbers)) }
            .filter { it == checkCount }
            .count()
    }

    fun getEarningRate(winningNumbers: List<Int>): Double {
        val totalPrizeMoney = getTotalPrizeMoney(winningNumbers)
        val budgetMoney = allLottos.size * COST_PER_ONE_LOTTO
        return totalPrizeMoney.div(budgetMoney)
    }

    private fun getTotalPrizeMoney(winningNumbers: List<Int>): Double {
        return Coincidence.values()
            .map { check(winningNumbers, it.coincidenceCount) * it.prizeMoney }
            .sum()
            .toDouble()
    }

    companion object {
        private const val COST_PER_ONE_LOTTO: Double = 1000.toDouble()

        private fun createLottos(count: Int): List<Lotto> {
            return (1..count).map { Lotto(LottoNumberPool().getLottoNumbers()) }
        }
    }
}
