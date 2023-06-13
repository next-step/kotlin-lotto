package lotto.domain

enum class Rank(
    private val predicate: (Int) -> Boolean,
    val matchCount: Int,
    val reward: Money
) {
    FIRST({ it == FIRST.matchCount }, 6, Money(2_000_000_000)),
    SECOND({ it == SECOND.matchCount }, 5, Money(1_500_000)),
    THIRD({ it == THIRD.matchCount }, 4, Money(50_000)),
    FOURTH({ it == FOURTH.matchCount }, 3, Money(5_000)),
    MISS({ it < 3 }, 0, Money(0));

    companion object {
        fun valueOf(matchCount: Int): Rank = values().find { it.predicate(matchCount) }
            ?: throw IllegalArgumentException("Invalid Match Count. Input: $matchCount")

        fun groupingByRank(valueTransform: (Rank) -> Int): Map<Rank, Int> = values().associateBy({ it }, valueTransform)
    }
}
