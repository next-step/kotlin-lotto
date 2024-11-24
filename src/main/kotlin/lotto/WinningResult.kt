package lotto

enum class WinningResult(val countOfMatch: Int, val winnings: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(2, 0),
    ;

    companion object {
        fun valueOf(
            countOfMatch: Int,
            matchBonus: Boolean = false,
        ): WinningResult {
            return when {
                countOfMatch == 5 && matchBonus -> return SECOND
                countOfMatch == 5 && !matchBonus -> return THIRD
                else -> entries.find { it.countOfMatch == countOfMatch } ?: LOSE
            }
        }
    }
}
