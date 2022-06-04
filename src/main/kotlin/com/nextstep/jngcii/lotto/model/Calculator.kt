package com.nextstep.jngcii.lotto.model

import kotlin.math.floor

object Calculator {
    private const val LOTTO_PRICE = 1_000

    fun calculateLottoCount(payment: Int): Int {
        if (payment < 0) {
            throw IllegalArgumentException("구입금액이 음수일 수 없습니다")
        }
        return payment / LOTTO_PRICE
    }

    fun calculateYield(count: Int, ranks: Ranks): Double {
        val purchaseAmount = (count * LOTTO_PRICE).toDouble()

        return floor(ranks.sumOfPrice / purchaseAmount * 100) / 100f
    }
}
