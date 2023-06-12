package lottery

import java.util.EnumMap

enum class Rank(
    val price: Int,
    val rankingMetric: (Int) -> Boolean
) {
    NOTHING(0, { it in 0..2 }),
    FOURTH(5_000, { it == 3 }),
    THIRD(50_000, { it == 4 }),
    SECOND(1_500_000, { it == 5 }),
    FIRST(2_000_000_000, { it == 6 }),
    ;

    companion object {
        private const val DEFAULT_RANK_COUNT = 0

        fun from(matchCount: Int) = Rank.values()
            .firstOrNull { it.rankingMetric(matchCount) } ?: throw IllegalArgumentException("로또 룰에 벗어난 수는 입력될 수 없다")

        fun Map<Rank, Int>.fillMissRankWithDefault(): Map<Rank, Int> = Rank.values()
                .associateWith { this.getOrDefault(it, DEFAULT_RANK_COUNT) }
    }
}
