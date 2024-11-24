package lotto.infrastructure

import lotto.domain.LottoPurchaseAmount
import lotto.domain.ProfitRateCalculator
import java.math.BigDecimal
import java.math.RoundingMode

class DefaultProfitRateCalculator : ProfitRateCalculator {
    override fun calculate(
        totalPrize: Int,
        lottoPurchaseAmount: LottoPurchaseAmount,
    ): Double {
        return BigDecimal(totalPrize.toDouble() / lottoPurchaseAmount.amount)
            .setScale(2, RoundingMode.DOWN)
            .toDouble()
    }
}
