package lotto.domain

enum class Rank(val matchCount: Int, prizeMoney: Money) {

    FIRST(6, Money(2_000_000_000)),
    THIRD(5, Money(1_500_000)),
    FOURTH(4, Money(50_000)),
    FIFTH(3, Money(5_000)),
    MISS(0, Money.ZERO);

    companion object {

        fun of(matchCount: Int) = values().find { it.matchCount == matchCount } ?: MISS
    }
}