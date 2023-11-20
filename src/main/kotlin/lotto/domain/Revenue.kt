package lotto.domain

enum class Revenue(
    val matchCount: Int,
    val prizeMoney: Int,
    val isMatchBonus: Boolean
) {
    FIVE(3, 5_000, false),
    FOUR(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    companion object {
        fun of(matchCount: Int, isMatchBonus: Boolean): Revenue {
            return values().first { it.matchCount == matchCount && it.isMatchBonus == isMatchBonus }
        }
    }
}
