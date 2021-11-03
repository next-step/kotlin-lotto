package lotto.domain

enum class Rank(
    val matchCount: Int,
    val winningMoney: Int,
    val isBonus: Boolean = false,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    fun getTotalWinningMoney(matchResultValue: Int): Int {
        return this.winningMoney * matchResultValue
    }

    companion object {
        fun valueOf(matchCount: Int, isBonus: Boolean = false): Rank {
            return values().filter { it.isBonus == isBonus }
                .find { it.matchCount == matchCount } ?: MISS
        }
    }
}
