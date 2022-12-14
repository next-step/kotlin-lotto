package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode.HALF_DOWN

class WinningResult(
    private val lottos: Lottos,
    private val winningNumbers: WinningNumbers
) {
    fun getTotalWinningAmount(): BigDecimal {
        return lottos.map { winningNumbers.prizeOf(it) }
            .map { it.winningAmount }
            .reduce(BigDecimal::add)
    }

    fun getReturnRatio(): BigDecimal {
        val amount = getTotalWinningAmount()
        return amount.divide(lottos.purchaseAmount, RETURN_RATIO_SCALE, HALF_DOWN)
    }

    fun getCountOf(prize: LottoPrize): Int {
        return lottos.map(winningNumbers::prizeOf).count { it == prize }
    }

    companion object {
        private const val RETURN_RATIO_SCALE = 2
    }
}
