package lotto.domain.prize

enum class LottoPrize(val numberOfMatches: Int, val prizeAmount: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    companion object {
        fun of(numberOfMatches: Int) = values().find { it.numberOfMatches == numberOfMatches } ?: NONE
    }
}
