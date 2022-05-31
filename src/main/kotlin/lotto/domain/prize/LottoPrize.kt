package lotto.domain.prize

enum class LottoPrize(val numberOfMatches: Int, val matchesBonus: Boolean, val prizeAmount: Int) {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    companion object {
        fun of(numberOfMatches: Int, matchesBonus: Boolean = false) = values()
            .find { it.numberOfMatches == numberOfMatches && it.matchesBonus == matchesBonus }
            ?: MISS
    }
}
