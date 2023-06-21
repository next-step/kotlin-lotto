package lotto

import java.math.BigDecimal
import java.math.RoundingMode

object LottoDrawingMachine {
    fun draw(winningLotto: WinningLotto, lottos: Lottos): DrawResult {
        val rankPrizes = rankPrizes(winningLotto, lottos)
        val roi = calculateRoi(rankPrizes, lottos)
        return DrawResult(rankPrizes, roi.setScale(2, RoundingMode.FLOOR).toString())
    }

    private fun calculateRoi(rankPrizes: List<RankPrize>, lottos: Lottos): BigDecimal {
        val totalReward = rankPrizes.sumOf { it.getTotalReward() }
        val invested = lottos.sumOf { it.salePrice }
        return BigDecimal((totalReward.toDouble() / invested.toDouble()))
    }

    private fun rankPrizes(winningLotto: WinningLotto, lottos: Lottos): List<RankPrize> {
        val matchedRankPrizes = lottos.asSequence()
            .map { winningLotto.countMatch(it) }
            .filter { it.getTotalMatch() >= 3 }
            .mapNotNull { it.toRank() }
            .groupBy { it }
            .map { RankPrize(it.key, it.value.size) }

        val skeletonRankPrizes = Rank.values().asSequence()
            .filterNot { rank -> matchedRankPrizes.any { rankPrize -> rankPrize.rank == rank } }
            .map { RankPrize(it, 0) }

        return matchedRankPrizes.plus(skeletonRankPrizes).sortedBy { it.rank.reward }
    }

    data class DrawResult(
        val rankPrizes: List<RankPrize>,
        val totalRoi: String
    )

    data class RankPrize(
        val rank: Rank,
        val winnerCount: Int
    ) {
        fun getTotalReward() = rank.reward * winnerCount
    }
}
