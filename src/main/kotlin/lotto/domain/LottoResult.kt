package lotto.domain

import kotlin.math.floor

data class LottoResult(
    private val ranks: Map<LottoRank, Int>
) {

    fun getRateOfReturn(customer: Customer): Double {
        val amountSum = this.ranks.map { it.key.amount * it.value }.sumOf { it.toDouble() }
        return floor((amountSum / customer.money) * 100) / 100.0
    }
    operator fun get(lottoWinning: LottoRank) = ranks[lottoWinning]
}
