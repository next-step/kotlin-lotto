package lotto.domain

import lotto.domain.LottoStore.Companion.LOTTO_PRICE
import lotto.domain.vo.Amount
import lotto.domain.vo.RankFrequency

class LottoResult(
    private val rankCounts: Map<Rank, RankFrequency>,
) {
    fun getEarningRate(): Double {
        val totalPrize = rankCounts
            .map { (rank, rankFreq) -> rank.winningMoney * rankFreq.value }
            .sum()
            .let { Amount.of(it.value) }

        val totalTicketPrice = rankCounts.values
            .sum()
            .let { Amount.of(it.value * LOTTO_PRICE) }

        return (totalPrize / totalTicketPrice).toDouble()
    }

    fun getResultTable(): List<List<Int>> {
        val result = Rank.values().map { rank ->
            val rankFrequency = rankCounts[rank] ?: RankFrequency.of(0)
            val matchedCount = rank.matchCount
            val winningMoney = rank.winningMoney
            val frequency = rankFrequency.value

            listOf(matchedCount.value, winningMoney.value, frequency)
        }

        return result
    }

    private fun Iterable<Amount>.sum() = Amount.of(sumOf { it.value })
    private fun Iterable<RankFrequency>.sum() = RankFrequency.of(sumOf { it.value })
}
