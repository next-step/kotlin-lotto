package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode.HALF_DOWN

class WinningResult(
    private val lottos: Lottos,
    private val winningNumbers: WinningNumbers
) {
    fun getTotalPrize(): BigDecimal {
        return lottos.map { winningNumbers.prizeOf(it) }
            .map { it.prize }
            .reduce(BigDecimal::add)
    }

    fun getReturnRatio(): BigDecimal {
        val winningPrize = getTotalPrize()
        return winningPrize.divide(lottos.purchaseAmount, RETURN_RATIO_SCALE, HALF_DOWN)
    }

    fun getCountOf(target: LottoPrize): Int {
        return lottos.map(winningNumbers::prizeOf).count { it == target }
    }

    companion object {
        private const val RETURN_RATIO_SCALE = 2
    }
}
