package com.nextstep.jngcii.lotto.model

import kotlin.math.floor

object Calculator {
    private const val LOTTO_PRICE = 1_000

    fun calculateYield(count: Int, ranks: Ranks): Double {
        val purchaseAmount = (count * LOTTO_PRICE).toDouble()

        return floor(ranks.sumOfPrice / purchaseAmount * 100) / 100f
    }
}
