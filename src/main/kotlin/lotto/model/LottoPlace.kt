package lotto.model

enum class LottoPlace(val winnings: Money, val winningCount: Int) {
    FIRST(Money(2_000_000_000), 6),
    SECOND(Money(1_500_000), 5),
    THIRD(Money(50_000), 4),
    FOURTH(Money(5_000), 3),
    MISS(Money(0), 0);

    companion object {
        fun match(count: Int): LottoPlace {
            for (value in values()) {
                if (value.winningCount == count) {
                    return value
                }
            }
            return MISS
        }
    }
}
