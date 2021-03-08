package lotto.model

class Lottos(private val lottos: List<Lotto>) {
    var myLottos: List<Lotto>
        private set

    init {
        myLottos = lottos
    }

    constructor(lottoNumPool: LottoNumberPool, count: Int) : this(createLottos(lottoNumPool, count))

    fun check(winningLotto: Lotto, checkCount: Int): Int {
        return myLottos
            .map { it.getWinningCount(winningLotto) }
            .filter { it == checkCount }
            .count()
    }

    fun getEarningRate(winningLotto: Lotto): Double {
        val totalPrizeMoney = getTotalPrizeMoney(winningLotto)
        val budgetMoney = myLottos.size * COST_PER_ONE_LOTTO

        return totalPrizeMoney.div(budgetMoney)
    }

    private fun getTotalPrizeMoney(winningLotto: Lotto): Double {
        return Coincidence.values()
            .map { check(winningLotto, it.coincidenceCount) * it.prizeMoney }
            .sum()
            .toDouble()
    }

    companion object {
        private const val COST_PER_ONE_LOTTO: Double = 1000.toDouble()

        private fun createLottos(lottoNumPool: LottoNumberPool, count: Int): List<Lotto> {
            return (1..count).map { lottoNumPool.getOneLotto() }
        }
    }
}
