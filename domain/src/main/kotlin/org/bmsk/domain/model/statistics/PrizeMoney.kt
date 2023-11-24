package org.bmsk.domain.model.statistics

enum class PrizeMoney(val count: MatchCount, val money: Int) {
    NONE(MatchCount.ZERO, 0),
    PRIZE_3(MatchCount.THREE, 5000),
    PRIZE_4(MatchCount.FOUR, 50000),
    PRIZE_5(MatchCount.FIVE, 1500000),
    PRIZE_6(MatchCount.SIX, 2000000000),
    ;

    companion object {
        fun from(matchCount: MatchCount) = values().firstOrNull { it.count == matchCount } ?: NONE
    }
}
