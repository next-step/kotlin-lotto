package lotto.domain

enum class Rank(
    val matchCount: Int,
    val prizeAmount: Int,
    private val match: (Int, Boolean) -> Boolean,
) {
    FIRST(6, 2_000_000_000, { count, _ -> count == 6 }),
    SECOND(5, 30_000_000, { count, isBonusMatch -> count == 5 && isBonusMatch }),
    THIRD(5, 1_500_000, { count, _ -> count == 5 }),
    FOURTH(4, 50_000, { count, _ -> count == 4 }),
    FIFTH(3, 5_000, { count, _ -> count == 3 }),
    MISS(0, 0, { count, _ -> count < 3 }), ;

    companion object {
        fun findByMatchCount(
            matchCount: Int,
            isBonusMatch: Boolean = false,
        ): Rank? {
            return entries.firstOrNull { it.match(matchCount, isBonusMatch) }
        }
    }
}
