package lotto.domain

enum class Rank(
    val matchCount: Int,
    val winningMoney: Int,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    fun getTotalWinningMoney(matchResultValue: Int): Int {
        return this.winningMoney * matchResultValue
    }

    companion object {
        fun valueOf(matchCount: Int): Rank {
            return values().find { it.matchCount == matchCount } ?: MISS
        }
    }
}
