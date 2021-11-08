package lotto.domain

enum class Rank(val matchCount: Int, val prize: Int, val matchBonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    fun prizeByCount(count: Int): Int = count * prize

    companion object {
        fun rankByMatchCount(matchCount: Int, matchBonus: Boolean): Rank {
            return values().firstOrNull { it.matchCount == matchCount && it.matchBonus == matchBonus } ?: MISS
        }
    }
}
