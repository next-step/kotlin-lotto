package lotto.domain

import lotto.domain.ExceptionType.NOT_DEFINED_HIT
import lotto.domain.ExceptionType.NOT_DEFINED_HIT_FOR_WINNINGS

enum class LotteryWinningTypes(val hits: Int, val winnings: Int) {
    Zero(0, 0),
    One(1, 0),
    Two(2, 0),
    Three(3, 5_000),
    Four(4, 50_000),
    Five(5, 1_500_000),
    Six(6, 2_000_000_000);

    companion object {
        const val MINIMUM_WINNING_HITS = 3
        fun findWinningByHits(hits: Int) =
            values()
                .find { it.hits == hits }?.winnings ?: throw IllegalArgumentException(NOT_DEFINED_HIT_FOR_WINNINGS)

        fun findTypeByHits(hits: Int) =
            values()
                .find { it.hits == hits } ?: throw IllegalArgumentException(NOT_DEFINED_HIT)
    }
}
