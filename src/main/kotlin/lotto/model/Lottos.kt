package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode

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

    fun getEarningRate(winningLotto: Lotto): BigDecimal {
        val totalPrizeMoney = getTotalPrizeMoney(winningLotto)
        val budgetMoney = (myLottos.size * COST_PER_ONE_LOTTO).toBigDecimal()

        return totalPrizeMoney.divide(budgetMoney, TWO_DECIMAL_PLACES, RoundingMode.FLOOR)
    }

    private fun getTotalPrizeMoney(winningLotto: Lotto): BigDecimal {
        return Coincidence.values()
            .map { check(winningLotto, it.coincidenceCount) * it.prizeMoney }
            .sum()
            .toBigDecimal()
    }

    fun getCoincidenceCount(coincidence: Coincidence, winningLotto: Lotto, bonusNumber: LottoNumber): Int {
        return myLottos.count { coincidence == it.getResult(winningLotto, bonusNumber) }
    }

    companion object {
        private const val COST_PER_ONE_LOTTO: Double = 1000.toDouble()
        private const val TWO_DECIMAL_PLACES = 2

        private fun createLottos(lottoNumPool: LottoNumberPool, count: Int): List<Lotto> {
            return (1..count).map { lottoNumPool.getOneLotto() }
        }
    }
}
