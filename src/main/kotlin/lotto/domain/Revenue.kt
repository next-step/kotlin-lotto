package lotto.domain

enum class Revenue(
    val matchCount: Int,
    val prizeMoney: Int
) {
    FIVE(3, 5_000),
    FOUR(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun of(matchCount: Int, isMatchBonus: Boolean = false): Revenue {
            return when (val revenue = values().first { it.matchCount == matchCount }) {
                SECOND, THIRD -> {
                    if (isMatchBonus) {
                        return SECOND
                    }
                    THIRD
                }
                FIRST, FOUR, FIVE -> revenue
            }
        }
    }
}
