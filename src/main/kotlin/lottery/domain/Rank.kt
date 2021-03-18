package lottery.domain

enum class Rank(val matchCount: Int, val price: Int, val isBonus: Boolean) {
    FIRST(6, 200_000_000, false),
    SECOND(5, 200_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    companion object {
        fun isInTheRank(count: Int, isBonus: Boolean): Boolean {
            return values().filter { it.matchCount == count && it.isBonus == isBonus }.any()
        }

        fun valueOf(matchCount: Int): Rank {
            return values().first { it.matchCount == matchCount }
        }
    }
}
