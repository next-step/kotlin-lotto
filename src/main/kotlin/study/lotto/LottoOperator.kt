package study.lotto

import study.lotto.model.Lotto
import study.lotto.model.LottoNumber
import study.lotto.model.LottoStats
import study.lotto.model.Lottos
import kotlin.math.floor

/**
 * @author 이상준
 */
class LottoOperator {
    fun getBuyLottoCount(money: Int): Int {
        return money / 1000
    }

    fun buyLotto(buyCount: Int): Lottos {
        require(buyCount > 0)

        Lottos().apply {
            repeat(buyCount) {
                addLotto(Lotto(randomLotto()))
            }
        }.let { return it }
    }

    fun getProfitLotto(
        lottoStats: LottoStats,
        money: Int,
    ): Double {
        val total: Double = lottoStats.getStat().sumOf { it.rank.amount.toDouble() * it.count }
        return (total / (money * 10)).let { floor(it * 100) / 100 }
    }

    private fun randomLotto(): Set<LottoNumber> {
        return (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .sorted()
            .map { LottoNumber(it) }
            .toSet()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
