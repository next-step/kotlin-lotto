package lotto.domain

data class Statistics(val rank: Int, val numberOfMatch: Int) {
    companion object {
        private const val RANK_FIRST_NUMBER = 1
        private const val RANK_SECOND_NUMBER = 2
        private const val RANK_THIRD_NUMBER = 3
        private const val RANK_FOURTH_NUMBER = 4
        private const val RANK_FIFTH_NUMBER = 5

        private const val FIRST_RANK_EARNING = 2_000_000_000
        private const val SECOND_RANK_EARNING = 1_500_000
        private const val THIRD_RANK_EARNING = 50_000
        private const val FOURTH_RANK_EARNING = 5_000
        private const val FIFTH_RANK_EARNING = 0
        private const val NO_RANK_EARNING = 0

        fun of(
            userLottos: List<Lotto>,
            winningLotto: Lotto,
        ): List<Statistics> {
            val groupByRanking: Map<Int, List<Lotto>> =
                (5 downTo 1).associateWith { emptyList<Lotto>() } +
                    userLottos.groupBy { Match.lottoNumber(it, winningLotto) }

            return groupByRanking.map { Statistics(it.key, it.value.size) }.sortedByDescending { it.rank }
        }

        fun earningsRatio(statistics: Statistics): Long {
            return calculateEarningRatioByRanking(statistics.rank) * statistics.numberOfMatch.toLong()
        }

        private fun calculateEarningRatioByRanking(rank: Int) =
            when (rank) {
                RANK_FIRST_NUMBER -> FIRST_RANK_EARNING
                RANK_SECOND_NUMBER -> SECOND_RANK_EARNING
                RANK_THIRD_NUMBER -> THIRD_RANK_EARNING
                RANK_FOURTH_NUMBER -> FOURTH_RANK_EARNING
                RANK_FIFTH_NUMBER -> FIFTH_RANK_EARNING
                else -> NO_RANK_EARNING
            }
    }
}
