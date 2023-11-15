package study.lotto.domain

class LottoGameResult private constructor(
    val statistics: Map<PrizeGrade, Int>,
    val earningsRate: Double
) {
    companion object {
        fun getResult(lottoes: Lottoes, winningLotto: Lotto, bonusNumber: LottoNumber): LottoGameResult {
            val statistics = buildStatistics(lottoes.getPrizes(winningLotto, bonusNumber))
            val earningsRate = calculateEarningsRate(
                calculateTotalPrize(statistics),
                lottoes.size
            )

            return LottoGameResult(statistics, earningsRate)
        }
        private fun calculateEarningsRate(totalPrize: Long, lottoCount: Int): Double {
            val totalSpent = lottoCount * Lotto.PRICE_PER_TICKET
            return totalPrize.toDouble() / totalSpent
        }

        private fun buildStatistics(matchCounts: List<PrizeGrade>): Map<PrizeGrade, Int> {
            return matchCounts
                .filter { it.matchCount >= PrizeGrade.GRADE_5.matchCount }
                .groupingBy { it }
                .eachCount()
                .toMutableMap()
                .apply {
                    PrizeGrade.values().filter {
                        it.matchCount >= PrizeGrade.GRADE_5.matchCount
                    }.forEach {
                        putIfAbsent(it, 0)
                    }
                }
        }

        private fun calculateTotalPrize(statistics: Map<PrizeGrade, Int>): Long {
            return statistics.entries.sumOf { (prizeGrade, matchCount) ->
                prizeGrade.prizeAmount * matchCount
            }
        }
    }
}
