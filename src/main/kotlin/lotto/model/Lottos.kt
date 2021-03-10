package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode

class Lottos(val lottos: List<Lotto>) {
    constructor(lottoNumPool: LottoNumberPool, count: Int) : this(createLottos(lottoNumPool, count))

    fun check(winningLotto: Lotto, checkCount: Int): Int {
        return lottos
            .map { it.getMatchCount(winningLotto) }
            .filter { it == checkCount }
            .count()
    }

    fun getEarningRate(winningLotto: Lotto): BigDecimal {
        val totalPrizeMoney = getTotalPrizeMoney(winningLotto)
        val budgetMoney = (lottos.size * COST_PER_ONE_LOTTO).toBigDecimal()

        return totalPrizeMoney.divide(budgetMoney, TWO_DECIMAL_PLACES, RoundingMode.FLOOR)
    }

    private fun getTotalPrizeMoney(winningLotto: Lotto): BigDecimal {
        return Coincidence.values()
            .map { check(winningLotto, it.coincidenceCount) * it.prizeMoney }
            .sum()
            .toBigDecimal()
    }

    fun getCoincidenceCount(coincidence: Coincidence, winningLotto: Lotto, bonusNumber: LottoNumber): Int {
        return lottos.count { coincidence == it.getResult(winningLotto, bonusNumber) }
    }

    companion object {
        private const val COST_PER_ONE_LOTTO: Double = 1000.toDouble()
        private const val TWO_DECIMAL_PLACES = 2

        private fun createLottos(lottoNumPool: LottoNumberPool, count: Int): List<Lotto> {
            return (1..count).map { lottoNumPool.getOneLotto() }
        }
    }
}
