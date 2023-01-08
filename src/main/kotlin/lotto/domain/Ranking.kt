package lotto.domain

enum class Ranking(
    val matchCount: Int,
    val winningMoney: Int
) {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    fun getTotalWinningMoney(matchResultValue: Int): Int {
        return winningMoney * matchResultValue
    }

    companion object {
        fun valueOf(matchCount: Int, isBonus: Boolean = false): Ranking {
            return values().find {
                if (matchCount == 5 && !isBonus) {
                    return THIRD
                }
                it.matchCount == matchCount
            } ?: MISS
        }
    }
}
