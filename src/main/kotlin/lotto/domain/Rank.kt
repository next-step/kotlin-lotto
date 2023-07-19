package lotto.domain

enum class Rank(
    val count: Int,
    val winningAmount: GameMoney,
    val bonusRequired: Boolean = false
) {
    FIRST(6, 2_000_000_000.toMoney()),
    SECOND(5, 30_000_000.toMoney(), true),
    THIRD(5, 1_500_000.toMoney()),
    FOURTH(4, 50_000.toMoney()),
    FIFTH(3, 5_000.toMoney()),
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

private fun Int.toMoney(): GameMoney {
    return GameMoney.from(this)
}
