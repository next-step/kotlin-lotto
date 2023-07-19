package lotto.domain.rank

import lotto.domain.GameMoney
import lotto.domain.rank.BonusCondition.*

enum class Rank(
    val winningAmount: GameMoney,
    private val rank: Int,
    private val condition: RankCondition,
) {
    FIRST(2_000_000_000.toMoney(), 1, RankCondition(6, NO_MATTER)),
    SECOND(30_000_000.toMoney(), 2, RankCondition(5, NEED_MATCH)),
    THIRD(1_500_000.toMoney(), 3, RankCondition(5, NEED_NOT_MATCH)),
    FOURTH(50_000.toMoney(), 4, RankCondition(4, NO_MATTER)),
    FIFTH(5_000.toMoney(), 5, RankCondition(3, NO_MATTER)),
    ;

    val count: Int
        get() = condition.count

    companion object {
        fun from(countOfMatch: Int, bonusMatched: Boolean): Rank? {
            return values().filter { it.condition.match(countOfMatch, bonusMatched) }
                .minByOrNull { it.rank }
        }
    }
}

private fun Int.toMoney(): GameMoney {
    return GameMoney.from(this)
}
