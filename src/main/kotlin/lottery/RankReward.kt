package lottery

enum class RankReward(val matchedNumberCount: Int, val money: Money) {
    RANK_1(6, Money(2_000_000_000)),
    RANK_2(5, Money(1_500_000)),
    RANK_3(4, Money(50_000)),
    RANK_4(3, Money(5_000)),
    ;

    companion object {
        fun fromMatchedNumberCount(matchedNumberCount: Int): RankReward? {
            return entries.firstOrNull { it.matchedNumberCount == matchedNumberCount }
        }
    }
}
