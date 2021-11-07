package lotto.domain

enum class Ranking(val reward: Money, val matches: Int) {
    FIRST(Money.from(2_000_000_000L), 6),
    SECOND(Money.from(1_500_000L), 5),
    THIRD(Money.from(50_000L), 4),
    FOURTH(Money.from(5_000L), 3),
    NONE(Money.from(0L), 0);

    companion object {
        fun calculate(matches: Int): Ranking = values().find { it.matches == matches } ?: NONE

        fun isNone(ranking: Ranking): Boolean = ranking == NONE
    }
}
