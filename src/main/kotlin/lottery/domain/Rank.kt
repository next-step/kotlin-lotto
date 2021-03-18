package lottery.domain

enum class Rank(val matchCount: Int, val price: Int, val hasBonus: Boolean) {
    FIRST(6, 200_000_000, false),
    SECOND(5, 200_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    companion object {
        fun isInTheRank(count: Int, hasBonus: Boolean): Boolean {
            return values().filter { it.matchCount == count && it.hasBonus == hasBonus }.any()
        }

        fun valueOf(matchCount: Int): Rank {
            return values().first { it.matchCount == matchCount }
        }

        fun valueOf(matchCount: Int, hasBonus: Boolean): Rank {
            return values().first { it.matchCount == matchCount && it.hasBonus == hasBonus}
        }
    }
}
