package lotto.model

enum class LottoRank(
    val prize: Long,
    val countCondition: Int,
    matchConditionStrategy: MatchConditionStrategy,
) {
    FIRST(2_000_000_000, 6, MatchConditionStrategy.EXACTLY_COUNT),
    SECOND(1_500_000, 5, MatchConditionStrategy.EXACTLY_COUNT),
    THIRD(50_000, 4, MatchConditionStrategy.EXACTLY_COUNT),
    FOURTH(5_000, 3, MatchConditionStrategy.EXACTLY_COUNT),
    MISS(0, 2, MatchConditionStrategy.LESS_THAN_COUNT),
    ;

    private val matchCondition: (Int) -> Boolean = matchConditionStrategy.strategyFactory(countCondition)

    private enum class MatchConditionStrategy(val strategyFactory: (Int) -> (Int) -> Boolean) {
        EXACTLY_COUNT({ count -> { it == count } }),
        LESS_THAN_COUNT({ count -> { it <= count } }),
        ;
    }

    companion object {
        fun rankOf(count: Int): LottoRank {
            return values()
                .firstOrNull { it.matchCondition(count) }
                ?: throw IllegalArgumentException("matched rank is not exist. provided count(`$count`)")
        }

        val Collection<LottoRank>.totalPrize: Long
            get() = this.sumOf { it.prize }
    }
}