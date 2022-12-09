package lotto

enum class RANKING(val winningCount: Int, val winningPrice: Int) {
    MISS(0, 0), FOURTH(3, 5000), THIRD(4, 50000), SECOND(5, 1500000), FIRST(6, 2000000000);

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
