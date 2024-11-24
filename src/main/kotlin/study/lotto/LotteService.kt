package study.lotto

import study.lotto.model.LottePrize
import study.lotto.model.Lotto
import kotlin.math.floor

/**
 * @author 이상준
 */
class LotteService {
    fun buyLotto(money: Int): List<Lotto> {
        return (0 until money / LOTTO_PRICE).map { Lotto(randomLotto()) }
    }

    fun matchLotto(
        lotto: Lotto,
        winLotto: Lotto,
    ): Int {
        return winLotto.lotteNumbers.intersect(lotto.lotteNumbers).size
    }

    private fun randomLotto(): Set<Int> {
        return (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled().take(LOTTO_NUMBER_COUNT).sorted().toSet()
    }

    fun profitLotto(
        statMap: Map<LottePrize, Int>,
        money: Int,
    ): Double {
        val total = statMap.map { it.key.amount * it.value }.sum()
        return (total.toDouble() / (money * 10)).let { floor(it * 100) / 100 }
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_COUNT = 6
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
