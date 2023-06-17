package lotto

import java.math.BigDecimal
import java.math.RoundingMode

class Lottos(
    private val lottos: List<Lotto>
) : List<Lotto> by lottos {
    fun getWinningCountsByPrize(winningLotto: Lotto, bonusLottoNumber: LottoNumber): Map<Prize, Int> {
        val winningCountByPrize = getWinningPrizes(winningLotto, bonusLottoNumber)
            .groupingBy { it }
            .eachCount()

        return Prize.values()
            .filter { it.isNotMiss() }
            .reversed()
            .associateWith { winningCountByPrize[it] ?: 0 }
    }

    fun getTotalProfitRate(winningLotto: Lotto, bonusLottoNumber: LottoNumber): BigDecimal {
        val totalPrizeAmount = getWinningPrizes(winningLotto, bonusLottoNumber).sumOf { it.prizeAmount }
        val purchaseAmount = LOTTO_PRICE * lottos.size
        return totalPrizeAmount.divide(purchaseAmount.toBigDecimal(), ROUND_SCALE, RoundingMode.HALF_UP)
    }

    private fun getWinningPrizes(winningLotto: Lotto, bonusLottoNumber: LottoNumber): List<Prize> {
        return lottos.map { it.getPrize(winningLotto, bonusLottoNumber) }
            .filter { it.isNotMiss() }
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
