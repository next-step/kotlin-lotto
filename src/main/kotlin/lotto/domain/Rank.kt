package lotto.domain

enum class Rank(val matchCount: Int, val prizeMoney: Money) {

    FIRST(6, Money(2_000_000_000)),
    SECOND(5, Money(30_000_000)),
    THIRD(5, Money(1_500_000)),
    FOURTH(4, Money(50_000)),
    FIFTH(3, Money(5_000)),
    MISS(0, Money.ZERO);

    companion object {
        private const val SECOND_OR_THIRD_MATCH_COUNT = 5

        fun of(matchCount: Int, bonusMatch: Boolean): Rank {
            if (matchCount == SECOND_OR_THIRD_MATCH_COUNT && bonusMatch) {
                return SECOND
            }

            return if (matchCount == SECOND_OR_THIRD_MATCH_COUNT) {
                THIRD
            } else {
                values().find { it.matchCount == matchCount } ?: MISS
            }
        }
    }
}
