package lotto.domain

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    companion object {
        fun prizeOfMatchCount(matchCount: Int): Int {
            return values().first { it.matchCount == matchCount }.prize
        }

        fun from(matchCount: Int): Rank {
            return values().first { it.matchCount == matchCount }
        }
    }
}
