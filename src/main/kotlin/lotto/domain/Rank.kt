package lotto.domain

enum class Rank(
    val isBonus: Boolean,
    val matchCount: Int,
    val reward: Money
) {
    FIRST(false, 6, Money(2_000_000_000)) {
        override fun matches(matchCount: Int, isBonus: Boolean): Boolean = this.matchCount == matchCount
    },
    SECOND(true, 5, Money(30_000_000)) {
        override fun matches(matchCount: Int, isBonus: Boolean): Boolean =
            this.isBonus == isBonus && this.matchCount == matchCount
    },
    THIRD(false, 5, Money(1_500_000)) {
        override fun matches(matchCount: Int, isBonus: Boolean): Boolean = this.matchCount == matchCount
    },
    FOURTH(false, 4, Money(50_000)) {
        override fun matches(matchCount: Int, isBonus: Boolean): Boolean = this.matchCount == matchCount
    },
    FIVE(false, 3, Money(5_000)) {
        override fun matches(matchCount: Int, isBonus: Boolean): Boolean = this.matchCount == matchCount
    },
    MISS(false, 2, Money(0)) {
        override fun matches(matchCount: Int, isBonus: Boolean): Boolean = matchCount <= this.matchCount
    };

    abstract fun matches(matchCount: Int, isBonus: Boolean): Boolean

    companion object {
        fun valueOf(matchCount: Int, isBonus: Boolean): Rank = values().find { it.matches(matchCount, isBonus) }
            ?: throw IllegalArgumentException("Invalid Match Count. Input: $matchCount")

        fun groupingByRank(valueTransform: (Rank) -> Int): Map<Rank, Int> = values().associateBy({ it }, valueTransform)
    }
}
