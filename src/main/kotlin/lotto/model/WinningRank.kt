package lotto.model

enum class WinningRank(
    val matchedNumberCount: Int,
    val prizeMoney: Int
) {

    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 1_500_000),
    THIRD_PRIZE(4, 50_000),
    FOURTH_PRIZE(3, 5_000),
    NONE(0, 0);

    companion object {
        fun findRanks(lottos: Lottos, winningNumbers: Lotto) = lottos.lottos.map { findRank(it, winningNumbers) }

        private fun findRank(lotto: Lotto, winningNumbers: Lotto): WinningRank {
            return values().find {
                it.matchedNumberCount == lotto.findMatchedNumberCount(winningNumbers)
            } ?: NONE
        }
    }
}
