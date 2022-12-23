package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode.HALF_DOWN

class WinningResult(
    private val purchaseAmount: BigDecimal,
    private val lottoPrizes: LottoPrizes
) {
    fun getTotalWinningAmount(): BigDecimal {
        return lottoPrizes.getTotalWinningAmount()
    }

    fun getReturnRatio(): BigDecimal {
        val amount = getTotalWinningAmount()
        return amount.divide(purchaseAmount, RETURN_RATIO_SCALE, HALF_DOWN)
    }

    fun getCountOf(prize: LottoPrize): Int {
        return lottoPrizes.getCountOf(prize)
    }

    companion object {
        private const val RETURN_RATIO_SCALE = 2

        fun of(lottos: Lottos, winningNumbers: WinningNumbers): WinningResult {
            return WinningResult(lottos.purchaseAmount, lottos.matchWith(winningNumbers))
        }
    }
}
