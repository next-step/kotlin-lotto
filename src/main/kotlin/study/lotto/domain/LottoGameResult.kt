package study.lotto.domain

class LottoGameResult private constructor(
    val statistics: Map<Int, Int>,
    val earningsRate: Double,
) {
    companion object {
        fun getResult(lottos: Lottos, winningLotto: Lotto): LottoGameResult {
            val statistics = buildStatistics(lottos.countMatches(winningLotto))
            val earningsRate = calculateEarningsRate(
                calculateTotalPrize(statistics),
                lottos.size
            )

            return LottoGameResult(statistics, earningsRate)
        }
        private fun calculateEarningsRate(totalPrize: Long, lottoCount: Int): Double {
            val totalSpent = lottoCount * Lotto.PRICE_PER_TICKET
            return totalPrize.toDouble() / totalSpent
        }

        private fun buildStatistics(matchCounts: List<Int>): Map<Int, Int> {
            return matchCounts
                .filter { it >= PrizeGrade.GRADE_5.matchCount }
                .groupingBy { it }
                .eachCount()
                .toMutableMap()
                .apply {
                    (PrizeGrade.GRADE_5.matchCount..PrizeGrade.GRADE_1.matchCount).forEach { putIfAbsent(it, 0) }
                }
        }

        private fun calculateTotalPrize(statistics: Map<Int, Int>): Long {
            return statistics.entries.sumOf { (key, value) ->
                PrizeGrade.getPrizeAmount(key) * value
            }
        }
    }
}
