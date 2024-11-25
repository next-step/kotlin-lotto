package lotto.domain.rank

enum class Rank(
    val matchCount: Int,
    val winningMoney: Int,
) {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {

        private val rankCalcStrategy = listOf(
            DefaultRankCalculateStrategy(),
            SecondRankCalculateStrategy(),
        )

        fun of(matchCount: Int, isBonusMatched: Boolean): Rank {
            return rankCalcStrategy
                .first { it.support(matchCount, isBonusMatched) }
                .calculate(matchCount, isBonusMatched)
        }
    }
}
