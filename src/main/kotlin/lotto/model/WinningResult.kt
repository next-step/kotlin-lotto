package lotto.model

import java.math.BigDecimal

class WinningResult(
    private val purchaseAmount: Money,
    private val lottoPrizes: LottoPrizes
) {
    fun getTotalWinningAmount(): Money {
        return lottoPrizes.getTotalWinningAmount()
    }

    fun getReturnRatio(): BigDecimal {
        val amount = getTotalWinningAmount()
        return amount.getReturnRatioOf(purchaseAmount)
    }

    fun getCountOf(prize: LottoPrize): Int {
        return lottoPrizes.getCountOf(prize)
    }

    companion object {
        fun of(lottos: Lottos, winningNumbers: WinningNumbers): WinningResult {
            return WinningResult(lottos.purchaseAmount, lottos.matchWith(winningNumbers))
        }
    }
}
