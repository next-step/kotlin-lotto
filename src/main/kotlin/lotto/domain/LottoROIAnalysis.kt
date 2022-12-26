package lotto.domain

import kotlin.math.roundToInt

class LottoROIAnalysis {

    fun returnOnInvestment(winningPrize: Int, purchaseAmount: Int): Double =
        ((winningPrize.toDouble() / purchaseAmount) * 100.0).roundToInt() / 100.0
}
