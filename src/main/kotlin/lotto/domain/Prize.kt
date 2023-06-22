package lotto.domain
enum class Prize(val matchCount: Int, val amount: Int, val requiresBonus: Boolean) {
    NO_PRIZE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);
    companion object {
        fun prizeFor(matchCount: Int, isBonusMatch: Boolean): Prize {
            values().find { it.matchCount == matchCount && it.requiresBonus == isBonusMatch }?.let { return it }
            return values().find { it.matchCount == matchCount && !it.requiresBonus } ?: NO_PRIZE
        }
    }
}
