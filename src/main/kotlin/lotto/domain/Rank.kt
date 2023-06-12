package lotto.domain

enum class Rank(private val predicate: (Int) -> Boolean, private val reward: Money) {
    FIRST({ it == 6 }, Money(2_000_000_000)),
    SECOND({ it == 5 }, Money(1_500_000)),
    THIRD({ it == 4 }, Money(50_000)),
    FOURTH({ it == 3 }, Money(5_000)),
    MISS({ it < 3 }, Money(0));

    companion object {
        fun valueOf(matchCount: Int): Rank = values().find { it.predicate(matchCount) }
            ?: throw IllegalArgumentException("Invalid Match Count. Input: $matchCount")

        fun associateBy(valueTransform: (Rank) -> Int): Map<Rank, Int> {
            return values().associateBy({ it }, valueTransform)
        }
    }
}
