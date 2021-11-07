package lotto.domain

enum class Ranking(
    val reward: Money,
    val matches: Int,
    val isMatched: (matches: Int, isContainBonusBall: Boolean) -> Boolean
) {
    FIRST(Money.from(2_000_000_000L), 6, { match, _ -> match == 6 }),
    SECOND(Money.from(30_000_000L), 5, { match, bonus -> match == 5 && bonus }),
    THIRD(Money.from(1_500_000L), 5, { match, bonus -> match == 5 && bonus }),
    FOURTH(Money.from(50_000L), 4, { match, _ -> match == 4 }),
    FIFTH(Money.from(5_000L), 3, { match, _ -> match == 3 }),
    NONE(Money.from(0L), 0, { match, _ -> match < 3 });

    companion object {
        fun calculate(matches: Int, isContainBonusBall: Boolean): Ranking =
            values().find { it.isMatched(matches, isContainBonusBall) } ?: NONE

        fun isNone(ranking: Ranking): Boolean = ranking == NONE

        fun isSecond(ranking: Ranking): Boolean = ranking == SECOND
    }
}
