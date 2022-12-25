package lotto

enum class RANKING(val winningCount: Int, val winningPrice: Int) {
    MISS(0, 0), FIFTH(3, 5_000), FOURTH(4, 50_000), THIRD(5, 1_500_000), SECOND(5, 30_000_000), FIRST(6, 2_000_000_000);

    companion object {
        fun countOf(winningCount: Int, bonusMatched: Boolean): RANKING {
            return when (winningCount) {
                FIFTH.winningCount -> FIFTH
                FOURTH.winningCount -> FOURTH
                SECOND.winningCount -> {
                    if (bonusMatched) SECOND else THIRD
                }
                FIRST.winningCount -> FIRST
                else -> MISS
            }
        }
    }
}
