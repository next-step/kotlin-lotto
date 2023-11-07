package study.lotto.domain

class LottoGame {
    fun calculateResult(lottos: Lottos, winningLotto: Lotto): LottoGameResult {
        val statistics = buildStatisticsMap(getMatchCounts(lottos, winningLotto))
        val earningsRate = calculateEarningsRate(
            calculateTotalPrize(statistics),
            lottos.count()
        )

        return LottoGameResult(statistics, earningsRate)
    }

    private fun getMatchCounts(lottos: Lottos, winningLotto: Lotto): List<Int> {
        return lottos.list.map { it.countMatches(winningLotto) }
    }

    private fun buildStatisticsMap(matchCounts: List<Int>): Map<Int, Int> {
        return matchCounts
            .filter { it >= GRADE_5 }
            .groupingBy { it }
            .eachCount()
            .toMutableMap()
            .apply {
                (GRADE_5..GRADE_1).forEach { putIfAbsent(it, 0) }
            }
    }

    private fun calculateTotalPrize(statistics: Map<Int, Int>): Long {
        return statistics.entries.sumOf { (key, value) ->
            getPrizeAmount(key) * value
        }
    }

    private fun calculateEarningsRate(totalPrize: Long, lottoCount: Int): Double {
        val totalSpent = lottoCount * Lotto.PRICE_PER_TICKET
        return totalPrize.toDouble() / totalSpent
    }

    private fun getPrizeAmount(matchCount: Int): Long {
        return when (matchCount) {
            GRADE_5 -> 5_000
            GRADE_4 -> 50_000
            GRADE_3 -> 1_500_000
            GRADE_1 -> 2_000_000_000
            else -> 0
        }
    }

    private companion object {
        const val GRADE_5 = 3
        const val GRADE_4 = 4
        const val GRADE_3 = 5
        const val GRADE_1 = 6
    }
}
