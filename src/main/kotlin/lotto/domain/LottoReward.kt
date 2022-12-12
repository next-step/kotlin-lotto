package lotto.domain

enum class LottoReward(val matchCount: Int, val rewardPrice: Money) {
    MATCH_THREE(3, Money(5000)),
    MATCH_FOUR(4, Money(50000)),
    MATCH_FIVE(5, Money(1500000)),
    MATCH_SIX(6, Money(2000000000)),
    MATCH_MISS(0, Money.ZERO),
    ;

    companion object {
        fun getRewardPriceOf(input: Int) = of(input).rewardPrice

        fun of(input: Int) = values().find { it.matchCount == input } ?: MATCH_MISS
    }
}
