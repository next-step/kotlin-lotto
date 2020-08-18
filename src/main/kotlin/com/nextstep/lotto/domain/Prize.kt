package com.nextstep.lotto.domain

enum class Prize(private val prize: Int, private val matchCount: Int) {
    NONE(0, 0),
    THREE(5000, 3),
    FOUR(50000, 4),
    FIVE(1500000, 5),
    SIX(2000000000, 6);

    companion object {
        fun findPrize(numberOfMatch: Int): Int {
            val prize = values().find { it.matchCount == numberOfMatch } ?: NONE

            return prize.prize
        }
    }
}
