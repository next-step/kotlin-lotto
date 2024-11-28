package lotto.step4.domain

enum class Rank(val matchCount: Int, val hasBonusNumber: Boolean, val winningAmount: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0),
    ;

    companion object {
        fun valueOf(
            matchCount: Int,
            hasBonusNumber: Boolean,
        ): Rank {
            return entries.find { it.matchCount == matchCount && it.hasBonusNumber == hasBonusNumber } ?: MISS
        }
    }
}
