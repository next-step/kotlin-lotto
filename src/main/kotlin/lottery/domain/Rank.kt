package lottery.domain

enum class Rank(
    val reward: Long,
    val equalCount: String,
    val rankingMetric: (Int, Boolean) -> Boolean
) {
    NOTHING(0, "0,1,2", { matchCount, _ -> matchCount in 0..2 }),
    FIFTH(5_000, "3", { matchCount, _ -> matchCount == 3 }),
    FOURTH(50_000, "4", { matchCount, _ -> matchCount == 4 }),
    THIRD(1_500_000, "5", { matchCount, isBonus -> matchCount == 5 && isBonus.not() }),
    SECOND(30_000_000, "5", { matchCount, isBonus -> matchCount == 5 && isBonus }),
    FIRST(2_000_000_000, "6", { matchCount, _ -> matchCount == 6 }),
    ;

    fun calculatePrice(count: Int) = reward.times(count)

    companion object {
        private const val DEFAULT_RANK_COUNT = 0
        val comparator: Comparator<Rank> = compareBy { it.reward }

        fun of(matchCount: Int, isBonus: Boolean): Rank = Rank.values()
            .firstOrNull { it.rankingMetric(matchCount, isBonus) } ?: throw IllegalArgumentException("로또 룰에 벗어난 수는 입력될 수 없다")

        fun Map<Rank, Int>.fillMissRankWithDefault() = Rank.values()
            .associateWith { this.getOrDefault(it, DEFAULT_RANK_COUNT) }
            .filterNot { it.key == NOTHING }
    }
}
