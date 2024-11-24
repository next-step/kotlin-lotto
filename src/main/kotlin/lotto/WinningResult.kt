package lotto

enum class WinningResult(val countOfMatch: Int, val winnings: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSE(2, 0),
    ;

    companion object {
        fun valueOf(countOfMatch: Int): WinningResult {
            return entries.find { it.countOfMatch == countOfMatch } ?: LOSE
        }
    }
}
