package lotto.domain

enum class Ranking(val reward: Money, val matches: Int) {
    FIRST(Money.valueOf(2_000_000_000L), 6),
    SECOND(Money.valueOf(1_500_000L), 5),
    THIRD(Money.valueOf(50_000L), 4),
    FOURTH(Money.valueOf(5_000L), 3),
    NONE(Money.valueOf(0L), 0);

    companion object {
        fun calculate(matches: Int): Ranking = values().find { it.matches == matches } ?: NONE

        fun isNone(ranking: Ranking): Boolean = ranking == NONE
    }
}
