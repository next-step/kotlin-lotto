package lotto.domain

enum class Rank(val condition: Pair<Int, Boolean>, val rewardPrice: Money) {
    FIRST(6 to false, Money(2000000000)),
    SECOND(5 to true, Money(30000000)),
    THIRD(5 to false, Money(1500000)),
    FOURTH(4 to false, Money(50000)),
    FIFTH(3 to  false, Money(5000)),
    MISS(0 to false, Money.ZERO),
    ;

    companion object {
        fun of(condition: Pair<Int, Boolean>): Rank {
            return values().find { it.condition == condition } ?: MISS
        }
    }
}

