package com.nextstep.lotto.domain

enum class Rank(val matchCount: Int, val winningMoney: Long) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        private val map = Rank.values().associateBy { it.matchCount }

        fun from(value: Int, isMatchBonus: Boolean): Rank {
            if (THIRD.matchCount == value && isMatchBonus) {
                return SECOND
            }
            return map[value] ?: MISS
        }
    }
}
