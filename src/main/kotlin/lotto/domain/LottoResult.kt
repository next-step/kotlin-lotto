package lotto.domain

data class LottoResult(
    private val rankToCount: Map<Rank, Int>,
) {
    val totalPrize: Int = rankToCount.entries.sumOf { it.key.prize * it.value }

    fun get(rank: Rank): Int = rankToCount[rank] ?: 0

    fun returnOnInvestment(payment: Payment): Double = totalPrize.toDouble() / payment.doubleValue()
}
