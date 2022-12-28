package com.nextstep.lotto.domain

enum class Rank(val matchCount: Int, val prize: Long) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    SEVENTH(0, 0);

    companion object {
        fun from(matchCount: Int): Rank {
            return Rank.values().find { it.matchCount == matchCount }
                ?: throw IllegalArgumentException("잘못된 값 - matchCount: $matchCount")
        }
    }
}
