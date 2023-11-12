package me.parker.nextstep.kotlinlotto.domain

enum class LottoRank(val matchCount: Int, val prize: Int) {

    FIRST(6, 2_000_000_000) {
        override fun match(matchCount: Int, matchedBonus: Boolean): Boolean {
            return matchCount == FIRST.matchCount
        }
    },
    SECOND(5, 30_000_000) {
        override fun match(matchCount: Int, matchedBonus: Boolean): Boolean {
            return matchCount == SECOND.matchCount && matchedBonus
        }
    },
    THIRD(5, 1_500_000) {
        override fun match(matchCount: Int, matchedBonus: Boolean): Boolean {
            return matchCount == THIRD.matchCount
        }
    },
    FOURTH(4, 50_000) {
        override fun match(matchCount: Int, matchedBonus: Boolean): Boolean {
            return matchCount == FOURTH.matchCount
        }
    },
    FIFTH(3, 5_000) {
        override fun match(matchCount: Int, matchedBonus: Boolean): Boolean {
            return matchCount == FIFTH.matchCount
        }
    },
    MISS(2, 0) {
        override fun match(matchCount: Int, matchedBonus: Boolean): Boolean {
            return matchCount <= MISS.matchCount
        }
    };

    abstract fun match(matchCount: Int, matchedBonus: Boolean): Boolean

    companion object {

        fun of(matchCount: Int, matchedBonus: Boolean): LottoRank {
            return values().find { it.match(matchCount, matchedBonus) } ?: MISS
        }
    }
}
