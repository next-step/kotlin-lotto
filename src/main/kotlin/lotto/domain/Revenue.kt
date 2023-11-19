package lotto.domain

enum class Revenue(
    val matchCount: Int,
    val prizeMoney: Int
) {
    FIRST(3, 5_000),
    SECOND(4, 50_000),
    THIRD(5, 1_500_000),
    FOUR(6, 2_000_000_000);

    companion object {
        fun of(matchCount: Int): Revenue {
            return values().first { it.matchCount == matchCount }
        }
    }
}
