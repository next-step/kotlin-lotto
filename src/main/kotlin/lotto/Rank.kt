package lotto

enum class Rank(val matchCount: Int, val winningPrice: Int, val isBonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(6, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSING(0, 0),
    ;

    companion object {
        fun from(matchCount: Int, isBonus: Boolean): Rank {
            if (matchCount == 6 && isBonus) {
                return SECOND
            }
            if (isBonus) {
                return values().singleOrNull { it.matchCount == matchCount - 1 && !it.isBonus } ?: LOSING
            }
            return values().singleOrNull { it.matchCount == matchCount && !it.isBonus } ?: LOSING
        }
    }
}
