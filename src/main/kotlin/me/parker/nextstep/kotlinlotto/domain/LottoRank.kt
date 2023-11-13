package me.parker.nextstep.kotlinlotto.domain

enum class LottoRank(val matchCount: Int, val prize: Int) {

    FIRST(6, 2_000_000_000) {
        override fun match(matchCount: Int): Boolean {
            return matchCount == FIRST.matchCount
        }
    },
    SECOND(5, 1_500_000) {
        override fun match(matchCount: Int): Boolean {
            return matchCount == SECOND.matchCount
        }
    },
    THIRD(4, 50_000) {
        override fun match(matchCount: Int): Boolean {
            return matchCount == THIRD.matchCount
        }
    },
    FOURTH(3, 5_000) {
        override fun match(matchCount: Int): Boolean {
            return matchCount == FOURTH.matchCount
        }
    },
    MISS(2, 0) {
        override fun match(matchCount: Int): Boolean {
            return matchCount <= MISS.matchCount
        }
    };

    abstract fun match(matchCount: Int): Boolean

    companion object {

        fun of(matchCount: Int): LottoRank {
            return values().find { it.match(matchCount) } ?: MISS
        }
    }
}
