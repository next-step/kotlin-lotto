package lotto.domain

import java.util.EnumMap

data class LottoResult2(
    private val rankToCount: EnumMap<Rank2, Int>,
) {
    val totalPrize: Int = rankToCount.entries.sumOf { it.key.prize * it.value }

    fun get(rank: Rank2): Int = rankToCount.getOrDefault(rank, 0)

    fun returnOnInvestment(payment: LottoPayment): Double = totalPrize.toDouble() / payment.doubleValue()

    companion object {
        fun from(rankToCount: Map<Rank2, Int>): LottoResult2 = LottoResult2(EnumMap(rankToCount))

        fun of(vararg counts: Pair<Rank2, Int>): LottoResult2 = from(counts.toMap())
    }
}
