package lotto

enum class RANKING(val winningCount: Int, val winningPrice: Int) {
    MISS(0, 0), FOURTH(3, 5_000), THIRD(4, 50_000), SECOND(5, 1_500_000), FIRST(6, 2_000_000_000);

    companion object {
        fun countOf(winningCount: Int): RANKING {
            return when (winningCount) {
                FOURTH.winningCount -> FOURTH
                THIRD.winningCount -> THIRD
                SECOND.winningCount -> SECOND
                FIRST.winningCount -> FIRST
                else -> MISS
            }
        }
    }
}
