package lotto

import java.math.BigDecimal
import java.math.RoundingMode

class Lottos(
    private val lottos: List<Lotto>
) : List<Lotto> by lottos {
    fun getWinningLottoCountByMatchCount(winningLotto: Lotto, matchCount: Int): Int {
        return lottos.count { it.isMatchedByMatchCount(winningLotto, matchCount) }
    }

    fun getTotalProfitRate(winningLotto: Lotto): BigDecimal {
        val totalPrizeAmount = Prize.values()
            .map {
                val winningLottoCount = getWinningLottoCountByMatchCount(winningLotto, it.matchedCount)
                val prizeAmount = it.prizeAmount.multiply(winningLottoCount.toBigDecimal())
                prizeAmount
            }.sumOf { it }
        val purchaseAmount = LOTTO_PRICE * lottos.size

        return totalPrizeAmount
            .divide(purchaseAmount.toBigDecimal(), ROUND_SCALE, RoundingMode.HALF_UP)
    }

    companion object {
        private const val LOTTO_PRICE: Int = 1000
        private const val ROUND_SCALE = 2

        fun of(purchaseAmount: Int, lottoGenerator: LottoGenerator): Lottos {
            val quantity = purchaseAmount / LOTTO_PRICE
            return Lottos(List(quantity) { Lotto.draw(lottoGenerator) })
        }
    }
}
