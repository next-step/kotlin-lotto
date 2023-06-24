package lotto.prize

import lotto.vo.Money

enum class Prize(
    private val condition: MatchCondition,
    val amount: Money,
) {
    MATCH_3(SimpleMatchCondition(3), Money(5000)),
    MATCH_4(SimpleMatchCondition(4), Money(50000)),
    MATCH_5(SimpleMatchCondition(5), Money(1500000)),
    MATCH_5_BONUS(BonusMatchCondition(5), Money(30000000)),
    MATCH_6(SimpleMatchCondition(6), Money(2000000000));

    val matchCount: Int
        get() = condition.matchCount

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): Prize? {
            val bonusPrize = BONUS_PRIZES.find { it.condition.match(matchCount, bonusMatch) }
            if (bonusPrize != null) {
                return bonusPrize
            }

            return DEFAULT_PRIZES.find { it.condition.match(matchCount, bonusMatch) }
        }

        private val BONUS_PRIZES = Prize.values().filter { it.condition is BonusMatchCondition }
        private val DEFAULT_PRIZES = Prize.values().filter { it.condition is SimpleMatchCondition }
    }
}

