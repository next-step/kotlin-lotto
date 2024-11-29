package lotto.domain

data class Statistics(val rank: Int, val matchCount: Int) {
    fun earnings(): Long {
        return earningPriceByRanking() * matchCount
    }

    private fun earningPriceByRanking(): Long =
        when (rank) {
            RANK_FIRST -> FIRST_RANK_EARNING
            RANK_SECOND -> SECOND_RANK_EARNING
            RANK_THIRD -> THIRD_RANK_EARNING
            RANK_FOURTH -> FOURTH_RANK_EARNING
            RANK_FIFTH -> FIFTH_RANK_EARNING
            else -> NO_RANK_EARNING
        }

    companion object {
        private const val RANK_FIRST = 1
        private const val RANK_SECOND = 2
        private const val RANK_THIRD = 3
        private const val RANK_FOURTH = 4
        private const val RANK_FIFTH = 5

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
                (5 downTo 1).associateWith { emptyList<Lotto>() } +
                    userLottos.groupBy { Match.lottoNumber(it, winningLotto) }

            return groupByRanking.map { Statistics(it.key, it.value.size) }.sortedByDescending { it.rank }
        }

        fun calculateEarningRatio(
            statisticsList: List<Statistics>,
            amount: Int,
        ): Double {
            return statisticsList.sumOf { it.earnings() }.toDouble() / amount
        }
    }
}
