package lotto.domain

import kotlin.math.floor

data class Statistics(private val winningLotto: WinningLotto, private val lottos: List<Lotto>) {
    fun lottoResultGroupByRank(): Map<LottoRank, Int> {
        val initialRanks =
            LottoRank.entries
                .filter { it.matchCount in MINIMUM_MATCH_COUNT..MAXIMUM_MATCH_COUNT }
                .associateWith { 0 }

        val actualRanks =
            lottos.map { winningLotto.getUserRank(it) }
                .filter { it.matchCount in MINIMUM_MATCH_COUNT..MAXIMUM_MATCH_COUNT }
                .groupingBy { it }
                .eachCount()

        return initialRanks + actualRanks
    }

    fun calculateEarningRatio(price: Int): Double {
        val ratio =
            lottoResultGroupByRank()
                .map { (rank, count) -> rank.calculatePrize(count) }
                .sum().toDouble() / price

        return floor(ratio * 100) / 100
    }

    companion object {
        private const val MINIMUM_MATCH_COUNT = 3
        private const val MAXIMUM_MATCH_COUNT = 6
    }
}
