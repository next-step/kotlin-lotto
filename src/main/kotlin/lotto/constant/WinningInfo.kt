package lotto.constant

import java.lang.IllegalArgumentException

enum class WinningInfo(val winningCount: Int, val winningMoney: Long) {
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    SIX(6, 2000000000L);

    companion object {
        fun winningCounts(): List<Int> {
            return values().map { it.winningCount }
        }

        fun findBy(winningCount: Int): WinningInfo {
            return values().find { it.winningCount == winningCount } ?: throw IllegalArgumentException("없는 정보입니다. $winningCount")
        }
    }
}
