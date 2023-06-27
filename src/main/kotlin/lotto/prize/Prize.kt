package lotto.prize

import lotto.vo.Money

enum class Prize(
    private val condition: MatchCondition,
    val amount: Money,
) {
    NONE(RangedMatchCondition(2, Int.MAX_VALUE), Money(0)),
    MATCH_3(SimpleMatchCondition(3), Money(5_000)),
    MATCH_4(SimpleMatchCondition(4), Money(50_000)),
    MATCH_5(SimpleMatchCondition(5), Money(1_500_000)),
    MATCH_5_BONUS(BonusMatchCondition(5, 1), Money(30_000_000)),
    MATCH_6(SimpleMatchCondition(6), Money(2_000_000_000));

    val matchCount: Int
        get() = condition.matchCount

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): Prize {
            return PRIORITY_SORTED_PRIZES
                .find { it.condition.match(matchCount, bonusMatch) }
                ?: NONE
        }

        private val PRIORITY_SORTED_PRIZES = Prize
            .values()
            .sortedBy { it.condition.priority }
    }
}

