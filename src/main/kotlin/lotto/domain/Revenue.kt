package lotto.domain

enum class Revenue(
    val matchCount: Int,
    val prizeMoney: Int
) {
    FIRST(3, 5000),
    SECOND(4, 50000),
    THIRD(5, 1500000),
    FOUR(6, 2000000000);

    companion object {
        fun of(matchCount: Int): Revenue {
            return values().first { it.matchCount == matchCount }
        }
    }
}
