package lottery.domain

enum class RankReward(val rankValue: Int, val matchedNumberCount: Int, val money: Money) {
    RANK_1(1, 6, Money(2_000_000_000)),
    RANK_2(2, 5, Money(1_500_000)),
    RANK_3(3, 4, Money(50_000)),
    RANK_4(4, 3, Money(5_000)),
    ;

    override fun toString(): String {
        return "${matchedNumberCount}개 일치 ($money)"
    }

    companion object {
        fun fromMatchedNumberCount(matchedNumberCount: Int): RankReward? {
            return entries.firstOrNull { it.matchedNumberCount == matchedNumberCount }
        }

        fun sortLowToHighByRank(): List<RankReward> {
            return entries.sortedByDescending { it.rankValue }
        }
    }
}
