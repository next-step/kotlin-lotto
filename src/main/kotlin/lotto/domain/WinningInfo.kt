package lotto.domain

enum class WinningInfo(val winningCount: Int, val winningMoney: Long) {
    MISS(0, 0),
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    SIX(6, 2000000000L);

    companion object {
        fun findBy(winningCount: Int): WinningInfo {
            return values().find { it.winningCount == winningCount } ?: MISS
        }
    }
}
