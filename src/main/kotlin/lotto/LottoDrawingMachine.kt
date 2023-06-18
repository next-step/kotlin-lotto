package lotto

import java.math.BigDecimal
import java.math.RoundingMode

object LottoDrawingMachine {
    fun draw(winNumbers: List<Int>, lottos: Lottos): DrawResult {
        val rankPrizes = createRankPrizes(winNumbers, lottos)
        val roi = calculateRoi(rankPrizes, lottos)
        return DrawResult(rankPrizes, roi)
    }

    private fun calculateRoi(rankPrizes: List<RankPrize>, lottos: Lottos): String {
        val totalReward = rankPrizes.sumOf { it.reward * it.winnerCount }
        val invested = lottos.sumOf { it.salePrice }
        val roi = BigDecimal((totalReward.toDouble() / invested.toDouble()))
        return roi.setScale(2, RoundingMode.FLOOR).toString()
    }

    private fun createRankPrizes(winNumbers: List<Int>, lottos: Lottos): List<RankPrize> {
        return lottos.asSequence()
            .map { it.countMatch(winNumbers) }
            .filter { it >= 3 }
            .groupBy { it }
            .map { (number, occurrences) -> RankPrize(number, searchReward(number), occurrences.size) }
            .sortedBy { it.matchCount }
    }

    private fun searchReward(matchCount: Int): Long {
        return when (matchCount) {
            3 -> 5_000
            4 -> 50_000
            5 -> 1_500_000
            6 -> 2_000_000_000
            else -> throw IllegalArgumentException("$matchCount 개에 해당하는 당첨금이 없습니다")
        }
    }

    data class DrawResult(
        val rankPrizes: List<RankPrize>,
        val totalRoi: String
    )

    data class RankPrize(
        val matchCount: Int,
        val reward: Long,
        val winnerCount: Int
    )
}
