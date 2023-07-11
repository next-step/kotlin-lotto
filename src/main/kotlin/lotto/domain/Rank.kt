package lotto.domain

enum class Rank(
    val count: Int,
    val winningAmount: Int,
    val bonusRequired: Boolean = false
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    ;

    companion object {
        fun from(countOfMatch: Int, matchBonus: Boolean): Rank? {
            if (matchBonus && countOfMatch == SECOND.count) {
                return SECOND
            }
            return values().find { it.count == countOfMatch && !it.bonusRequired }
        }
    }
}
