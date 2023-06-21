package lotto

import java.lang.IllegalArgumentException
import java.math.BigDecimal
import java.math.RoundingMode

object LottoDrawingMachine {
    fun draw(winNumbers: List<Int>, lottos: Lottos): DrawResult {
        val rankPrizes = rankPrizes(winNumbers, lottos)
        val roi = calculateRoi(rankPrizes, lottos)
        return DrawResult(rankPrizes, roi)
    }

    private fun calculateRoi(rankPrizes: List<RankPrize>, lottos: Lottos): String {
        val totalReward = rankPrizes.sumOf { it.reward * it.winnerCount }
        val invested = lottos.sumOf { it.salePrice }
        val roi = BigDecimal((totalReward.toDouble() / invested.toDouble()))
        return roi.setScale(2, RoundingMode.FLOOR).toString()
    }

    private fun rankPrizes(winNumbers: List<Int>, lottos: Lottos): List<RankPrize> {
        val matchCountMap = Rank.values().associate { it.matchCount to 0 }.toMutableMap()

        lottos.asSequence()
            .map { it.countMatch(winNumbers) }
            .filter { it >= 3 }
            .groupBy { it }
            .forEach {
                matchCountMap[it.key] = it.value.size
            }
        return matchCountMap.map {
            RankPrize(it.key, Rank.ofMatchCount(it.key).reward, it.value)
        }.sortedBy { it.matchCount }
    }

    enum class Rank(val matchCount: Int, val reward: Long) {
        FIRST(6, 2_000_000_000),
        SECOND(5, 1_500_000),
        THIRD(4, 50_000),
        FOURTH(3, 5_000)
        ;
        companion object {
            fun ofMatchCount(matchCount: Int): Rank {
                return values().find { it.matchCount == matchCount }
                    ?: throw IllegalArgumentException("$matchCount 에 해당하는 등수가 없습니다")
            }
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
