package lotto.domain.model

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST_GRADE(6, 2_000_000_000),
    SECOND_GRADE(5, 30_000_000),
    THIRD_GRADE(5, 1_500_000),
    FOURTH_GRADE(4, 50_000),
    FIFTH_GRADE(3, 5_000),
    NO_MATCH(0, 0);

    companion object {

        fun safeValueOf(matchCount: Int, matchBonus: Boolean): Rank {
            if (matchBonus.not() && matchCount == 5) {
                return THIRD_GRADE
            }

            return values().find { rank ->
                rank.matchCount == matchCount
            } ?: NO_MATCH
        }
    }
}
