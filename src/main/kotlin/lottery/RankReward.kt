package lottery

enum class RankReward(val matchedNumberCount: Int, val money: Int) {
    RANK_1(6, 2_000_000_000),
    RANK_2(5, 1_500_000),
    RANK_3(4, 50_000),
    RANK_4(3, 5_000),
    ;

    companion object {
        fun fromMatchedNumberCount(matchedNumberCount: Int): RankReward? {
            return entries.firstOrNull { it.matchedNumberCount == matchedNumberCount }
        }
    }
}
