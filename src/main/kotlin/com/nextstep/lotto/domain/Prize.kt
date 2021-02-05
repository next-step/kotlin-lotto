package com.nextstep.lotto.domain

enum class Prize(val prize: Int, private val matchCount: Int) {
    NONE(0, 0),
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);

    companion object {
        fun findPrize(matchResult: MatchResult): Prize {
            val prize = values().find { it.matchCount == matchResult.numberOfMatch } ?: NONE
            return if (prize == THIRD && matchResult.matchBonus) {
                SECOND
            } else {
                prize
            }
        }
    }
}
