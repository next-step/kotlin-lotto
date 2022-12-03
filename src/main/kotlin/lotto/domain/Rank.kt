package lotto.domain

enum class Rank(val matchingCount: Int, val prize: Int) {
    FIRST_GRADE(6, 2_000_000_000),
    SECOND_GRADE(5, 30_000_000),
    THIRD_GRADE(5, 1_500_000),
    FOURTH_GRADE(4, 50_000),
    FIFTH_GRADE(3, 5_000),
    NO_MATCH(0, 0);

    companion object {

        fun safeValueOf(matchingCount: Int): Rank {
            return values().find { rank ->
                rank.matchingCount == matchingCount
            } ?: NO_MATCH
        }
    }
}
