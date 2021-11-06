package lotto.domain

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0),
    ;

    fun prizeByCount(count: Int): Int = count * prize

    companion object {
        fun rankByMatchCount(matchCount: Int): Rank {
            return values().firstOrNull { it.matchCount == matchCount } ?: MISS
        }
    }
}
