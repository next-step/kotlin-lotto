package com.nextstep.jngcii.lotto.model

import kotlin.math.floor

object Calculator {
    private const val LOTTO_PRICE = 1_000

    fun calculateYield(count: Int, ranks: List<Rank>): Double {
        val purchaseAmount = (count * LOTTO_PRICE).toDouble()
        val reward = ranks.sumOf { it.price }.toDouble()

        return floor(reward / purchaseAmount * 100) / 100f
    }
}
