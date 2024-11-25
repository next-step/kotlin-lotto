package lotto

enum class WinningResult(val countOfMatch: Int, val winnings: Money) {
    FIRST(6, Money(2_000_000_000)),
    SECOND(5, Money(30_000_000)),
    THIRD(5, Money(1_500_000)),
    FOURTH(4, Money(50_000)),
    FIFTH(3, Money(5_000)),
    LOSE(2, Money.ZERO),
    ;

    companion object {
        fun valueOf(
            countOfMatch: Int,
            matchBonus: Boolean = false,
        ): WinningResult =
            when {
                countOfMatch == 5 && matchBonus -> SECOND
                countOfMatch == 5 && !matchBonus -> THIRD
                else -> entries.find { it.countOfMatch == countOfMatch } ?: LOSE
            }
    }
}
