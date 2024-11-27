package lotto.domain

enum class RankReward(
    val rankValue: Int,
    val matchedCount: Int,
    val money: Money,
    private val matched: (Int, Boolean) -> Boolean,
) {
    FIRST(1, 6, Money(2_000_000_000), { matchedCount, _ -> matchedCount == FIRST.matchedCount }),
    SECOND(2, 5, Money(30_000_000), { matchedCount, matchBonus -> matchedCount == SECOND.matchedCount && matchBonus }),
    THIRD(3, 5, Money(1_500_000), { matchedCount, matchBonus -> matchedCount == THIRD.matchedCount && !matchBonus }),
    FOURTH(4, 4, Money(50_000), { matchedCount, _ -> matchedCount == FOURTH.matchedCount }),
    FIFTH(5, 3, Money(5_000), { matchedCount, _ -> matchedCount == FIFTH.matchedCount }),
    MISS(6, 0, Money(0), { matchedCount, _ -> matchedCount in MISS.matchedCount..<FIFTH.matchedCount }),
    ;

    override fun toString(): String {
        val bonusText = if (this in needMatchBonusRanks) ", 보너스 볼 일치" else ""
        return "${matchedCount}개 일치$bonusText ($money)"
    }

    companion object {
        fun valueOf(
            matchedCount: Int,
            matchBonus: Boolean,
        ): RankReward {
            return entries.firstOrNull { it.matched(matchedCount, matchBonus) }
                ?: throw IllegalArgumentException("잘못된 조회 조건입니다. $matchedCount, $matchBonus")
        }

        fun sortLowToHighByRank(): List<RankReward> {
            return entries.sortedByDescending { it.rankValue }
        }

        private val needMatchBonusRanks: List<RankReward> = listOf(SECOND)
    }
}
