package lottery.domain

enum class Rank(val matchCount: Int, val price: Int, val hasBonus: Boolean = false) {
    FIRST(6, 200_000_000),
    SECOND(5, 200_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    companion object {
        fun isInTheRank(count: Int, hasBonus: Boolean): Boolean {
            return values().filter { it.matchCount == count && it.hasBonus == hasBonus }.any()
        }

        fun valueOf(matchCount: Int, hasBonus: Boolean): Rank {
            return values().first { it.matchCount == matchCount && it.hasBonus == hasBonus}
        }
    }
}
