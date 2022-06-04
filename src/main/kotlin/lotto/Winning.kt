package lotto

enum class Winning(val matchCount: Int, val winningAmount: Int, val isMatchBonusNumber: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    companion object {
        fun of(count: Int, isMatchBonusNumber: Boolean): Winning {
            if (count == 5)
                return Winning.values().find {
                    it.matchCount == count && it.isMatchBonusNumber == isMatchBonusNumber
                } ?: FAIL
            return Winning.values().find { it.matchCount == count } ?: FAIL
        }
    }
}
