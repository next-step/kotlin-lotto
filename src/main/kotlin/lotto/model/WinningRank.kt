package lotto.model

enum class WinningRank(
    private val matchedNumberCount: Int,
    prizeMoney: Int
) {

    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, 1500000),
    THIRD_PRIZE(4, 50000),
    FOURTH_PRIZE(3, 5000),
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
