package lotto.domain

import lotto.model.LottoPrize
import kotlin.math.roundToInt

class LottoPrizeResults(
    private val prizes: List<LottoPrize>,
) {
    private val totalPrize: Int
        get() = prizes.sumOf { it.prize }

    val size: Int
        get() = prizes.size

    fun count(prize: LottoPrize): Int = prizes.count { it == prize }
    fun returnOnInvestment(purchaseAmount: Int): Double =
        ((totalPrize.toDouble() / purchaseAmount) * 100.0).roundToInt() / 100.0
}
