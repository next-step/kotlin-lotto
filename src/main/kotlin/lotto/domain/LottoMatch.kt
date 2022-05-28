package lotto.domain

enum class LottoMatch(val count: Int, val withBonus: Boolean, val reward: Long) {
    ZERO(0, false, 0),
    ONE(1, false, 0),
    TWO(2, false, 0),
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_WITH_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000);

    companion object {
        fun valuesWithReward(): List<LottoMatch> = values().filterNot { it.reward == 0L }

        fun find(count: Int, withBonus: Boolean): LottoMatch {
            return values().find { it.count == count && it.withBonus == withBonus } ?: ZERO
        }
    }
}
