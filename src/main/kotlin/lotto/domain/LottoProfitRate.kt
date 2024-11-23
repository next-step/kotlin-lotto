package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoProfitRate(val rate: Double) {
    constructor(totalPrize: Int, lottoPurchaseAmount: LottoPurchaseAmount) : this(
        BigDecimal(totalPrize.toDouble() / lottoPurchaseAmount.amount)
            .setScale(2, RoundingMode.DOWN)
            .toDouble(),
    )
}
