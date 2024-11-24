package lotto.domain

import java.util.EnumMap

data class LottoResult(
    private val rankToCount: EnumMap<Rank, Int>,
) {
    val totalPrize: Int = rankToCount.entries.sumOf { it.key.prize * it.value }

    fun get(rank: Rank): Int = rankToCount.getOrDefault(rank, 0)

    fun returnOnInvestment(payment: Payment): Double = totalPrize.toDouble() / payment.doubleValue()

    companion object {
        fun from(rankToCount: Map<Rank, Int>): LottoResult = LottoResult(EnumMap(rankToCount))

        fun of(vararg counts: Pair<Rank, Int>): LottoResult = from(counts.toMap())
    }
}
