package lotto.domain

import lotto.constant.FIFTH_RANK
import lotto.constant.FIRST_RANK
import lotto.constant.FOURTH_RANK
import lotto.constant.SECOND_RANK
import lotto.constant.THIRD_RANK

data class Statistics(val rank: Int, val matchCount: Int) {
    fun earnings(): Long {
        return earningPriceByRanking() * matchCount
    }

    private fun earningPriceByRanking(): Long =
        when (rank) {
            FIRST_RANK -> FIRST_RANK_EARNING
            SECOND_RANK -> SECOND_RANK_EARNING
            THIRD_RANK -> THIRD_RANK_EARNING
            FOURTH_RANK -> FOURTH_RANK_EARNING
            FIFTH_RANK -> FIFTH_RANK_EARNING
            else -> NO_RANK_EARNING
        }

    companion object {
        private const val FIRST_RANK_EARNING = 2_000_000_000L
        private const val SECOND_RANK_EARNING = 1_500_000L
        private const val THIRD_RANK_EARNING = 50_000L
        private const val FOURTH_RANK_EARNING = 5_000L
        private const val FIFTH_RANK_EARNING = 0L
        private const val NO_RANK_EARNING = 0L

        fun of(
            userLottos: List<Lotto>,
            winningLotto: Lotto,
        ): List<Statistics> {
            val groupByRanking: Map<Int, List<Lotto>> =
                (FIFTH_RANK downTo FIRST_RANK).associateWith { emptyList<Lotto>() } +
                    userLottos.groupBy { it.getIntersectSize(winningLotto) }

            val statistics: List<Statistics> =
                groupByRanking.map { Statistics(it.key, it.value.size) }.sortedByDescending { it.rank }
            return getRankedLottos(statistics)
        }

        fun calculateEarningRatio(
            statisticsList: List<Statistics>,
            amount: Int,
        ): Double {
            return statisticsList.sumOf { it.earnings() }.toDouble() / amount
        }

        private fun getRankedLottos(statisticsList: List<Statistics>): List<Statistics> {
            return statisticsList.filter { it.rank in FIRST_RANK..FIFTH_RANK && it.rank != SECOND_RANK }
        }
    }
}
