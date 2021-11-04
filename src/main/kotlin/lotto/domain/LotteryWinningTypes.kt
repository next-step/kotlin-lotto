package lotto.domain

import lotto.domain.ExceptionType.NOT_DEFINED_HIT_FOR_WINNINGS

enum class LotteryWinningTypes(val hits: Int, val winnings: Int) {
    Three(3, 5000),
    Four(4, 50000),
    Five(5, 1500000),
    Six(6, 2000000000);

    companion object {
        fun findWinningByHits(hits: Int) =
            values()
                .find { it.hits == hits }?.winnings ?: throw IllegalArgumentException(NOT_DEFINED_HIT_FOR_WINNINGS)
    }
}
