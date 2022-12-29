package lotto.domain

import lotto.model.Rank
import kotlin.math.roundToInt

class LottoRankResults(
    private val ranks: List<Rank>,
) {
    private val totalPrize: Int
        get() = ranks.sumOf { it.prize }

    val size: Int
        get() = ranks.size

    fun count(rank: Rank): Int = ranks.count { it == rank }
    fun returnOnInvestment(purchaseAmount: Int): Double =
        ((totalPrize.toDouble() / purchaseAmount) * 100.0).roundToInt() / 100.0
}
