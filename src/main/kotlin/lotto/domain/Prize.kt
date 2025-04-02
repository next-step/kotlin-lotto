package lotto.domain

enum class Prize(
    val value: Int,
    val matchCount: Int,
    private val matcher: (Int, Boolean) -> Boolean,
) {
    FIRST(2_000_000_000, 6, { count, _ -> count == 6 }),
    SECOND(30_000_000, 5, { count, hasBonus -> count == 5 && hasBonus }),
    THIRD(1_500_000, 5, { count, hasBonus -> count == 5 && !hasBonus }),
    FOURTH(50_000, 4, { count, _ -> count == 4 }),
    FIFTH(5_000, 3, { count, _ -> count == 3 }),
    NONE(0, 0, { _, _ -> false }),
    ;

    companion object {
        fun calculate(
            count: Int,
            hasBonus: Boolean,
        ) = entries.find { it.matcher(count, hasBonus) } ?: NONE
    }
}
