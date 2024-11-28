package lotto.domain

enum class RankReward(
    val rankValue: Int,
    val matchedCount: Int,
    val money: Money,
    val matchBonus: Boolean? = null,
) {
    FIRST(1, 6, Money(2_000_000_000)),
    SECOND(2, 5, Money(30_000_000), matchBonus = true),
    THIRD(3, 5, Money(1_500_000), matchBonus = false),
    FOURTH(4, 4, Money(50_000)),
    FIFTH(5, 3, Money(5_000)),
    ;

    private fun matched(
        matchedCount: Int,
        matchBonus: Boolean,
    ): Boolean {
        return when (this.matchBonus) {
            null -> this.matchedCount == matchedCount
            else -> this.matchedCount == matchedCount && this.matchBonus == matchBonus
        }
    }

    override fun toString(): String {
        val bonusText = if (this in needMatchBonusRanks) ", 보너스 볼 일치" else ""
        return "${matchedCount}개 일치$bonusText ($money)"
    }

    companion object {
        fun valueOf(
            matchedCount: Int,
            matchBonus: Boolean,
        ): RankReward? {
            return entries.firstOrNull { it.matched(matchedCount, matchBonus) }
        }

        fun sortLowToHighByRank(): List<RankReward> {
            return entries.sortedByDescending { it.rankValue }
        }

        private val needMatchBonusRanks: List<RankReward> = listOf(SECOND)
    }
}
