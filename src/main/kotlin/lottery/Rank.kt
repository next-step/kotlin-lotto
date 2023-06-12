package lottery

enum class Rank(
    val price: Int,
    val rankingMetric: (Int) -> Boolean
) {
    NOTHING(0, { it < 3 }),
    FOURTH(5_000, { it == 3 }),
    THIRD(50_000, { it == 4 }),
    SECOND(1_500_000, { it == 5 }),
    FIRST(2_000_000_000, { it == 6 }),
    ;

    companion object {
        fun from(matchCount: Int) = Rank.values()
            .firstOrNull { it.rankingMetric(matchCount) } ?: throw IllegalArgumentException("")
    }
}
