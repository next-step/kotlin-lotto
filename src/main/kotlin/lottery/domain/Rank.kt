package lottery.domain

enum class Rank(
    val reward: Long,
    val equalCount: String,
    val rankingMetric: (Int) -> Boolean
) {
    NOTHING(0, "0,1,2", { it in 0..2 }),
    FOURTH(5_000, "3", { it == 3 }),
    THIRD(50_000, "4", { it == 4 }),
    SECOND(1_500_000, "5", { it == 5 }),
    FIRST(2_000_000_000, "6", { it == 6 }),
    ;

    fun calculatePrice(count: Int) = reward.times(count)

    companion object {
        private const val DEFAULT_RANK_COUNT = 0
        val comparator: Comparator<Rank> = compareBy { it.reward }

        fun from(matchCount: Int) = Rank.values()
            .firstOrNull { it.rankingMetric(matchCount) } ?: throw IllegalArgumentException("로또 룰에 벗어난 수는 입력될 수 없다")

        fun Map<Rank, Int>.fillMissRankWithDefault(): Map<Rank, Int> = Rank.values()
            .associateWith { this.getOrDefault(it, DEFAULT_RANK_COUNT) }
            .filterNot { it.key == NOTHING }
    }
}
