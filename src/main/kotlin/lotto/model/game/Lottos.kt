package lotto.model.game

import lotto.model.result.Coincidence
import java.math.BigDecimal
import java.math.RoundingMode

class Lottos(val lottos: List<Lotto>) {
    constructor(count: Int) : this(createLottos(count))

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

    fun getCoincidenceCount(coincidence: Coincidence, winningLotto: WinningLotto): Int {
        return lottos.count { coincidence == it.getResult(winningLotto) }
    }

    private fun getTotalPrizeMoney(winningLotto: Lotto): BigDecimal {
        return Coincidence.values()
            .map { check(winningLotto, it.coincidenceCount) * it.prizeMoney }
            .sum()
            .toBigDecimal()
    }

    override fun toString(): String {
        return lottos
            .map { it.lottoNumbers }
            .joinToString { "," }
    }

    companion object {
        private const val COST_PER_ONE_LOTTO: Double = 1000.toDouble()
        private const val TWO_DECIMAL_PLACES = 2

        private fun createLottos(count: Int): List<Lotto> {
            return (1..count).map { LottoNumberPool.getOneLotto() }
        }
    }
}
