package lotto.domain

enum class Rank(val score: Score, val rewardPrice: Money) {
    FIRST(Score(6, false), Money(2000000000)),
    SECOND(Score(5, true), Money(30000000)),
    THIRD(Score(5, false), Money(1500000)),
    FOURTH(Score(4, false), Money(50000)),
    FIFTH(Score(3, false), Money(5000)),
    MISS(Score(0, false), Money.ZERO),
    ;

    companion object {
        fun of(score: Score): Rank {
            return when {
                (score.isMatchFiveWithBonus()) -> SECOND
                else -> values().find { it.score == score } ?: MISS
            }
        }
    }
}
