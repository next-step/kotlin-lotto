package autolotto.enums.prize

enum class Prize(
    val matchCount: Int,
    val prizeMoney: Int,
    val matchStrategy: (Int, Boolean) -> Boolean,
) {
    THREE(3, 5000, { count, _ -> count == 3 }),
    FOUR(4, 50000, { count, _ -> count == 4 }),
    FIVE(5, 1500000, { count, hasBonus -> count == 5 && !hasBonus }),
    BONUS(5, 30000000, { count, hasBonus -> count == 5 && hasBonus }),
    SIX(6, 2000000000, { count, _ -> count == 6 }),
    ;

    open fun calculatePrize(count: Int): Int {
        return count * prizeMoney
    }

    companion object {
        fun fromMatchCount(
            matchCount: Int,
            hasBonus: Boolean,
        ): Prize? {
            return entries.find { it.matchStrategy(matchCount, hasBonus) }
        }
    }
}
