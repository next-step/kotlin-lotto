package lotto.domain

enum class WinningPlace(
    val reward: Int,
    val requiredMatchingCount: Int,
) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    BLANK(0, 2);

    companion object {
        fun of(matchingCount: Int, matchingBonus: Boolean): WinningPlace {
            return when (matchingCount == SECOND.requiredMatchingCount) {
                true -> if (matchingBonus) SECOND else THIRD
                false -> values().find { it.requiredMatchingCount == matchingCount } ?: BLANK
            }
        }
    }
}
