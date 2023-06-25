package lotto.domain.model

enum class Prize(val matches: Int, val bonus: Boolean, val reward: Int) {
    NOTHING(0, false, 0),
    THREE_MATCH(3, false, 5_000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_MATCH_PLUS_BONUS(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    companion object {
        fun from(selectedBalls: SelectedBalls, lotto: Lotto): Prize {
            val hasBonusBall = lotto.numbers.contains(selectedBalls.bonus)
            val matchCount = lotto.numbers.filter { it in selectedBalls.winningNumbers.balls }.size
            return when (matchCount) {
                SIX_MATCH.matches -> SIX_MATCH
                FIVE_MATCH.matches -> if (hasBonusBall) FIVE_MATCH_PLUS_BONUS else FIVE_MATCH
                FOUR_MATCH.matches -> FOUR_MATCH
                THREE_MATCH.matches -> THREE_MATCH
                else -> NOTHING
            }
        }

        fun indexOf(matches: Int, bonus: Boolean): Int {
            return values().indexOfFirst { it.matches == matches && it.bonus == bonus }
        }
    }
}
