package lotto.domain

enum class PrizeLevel(val numberOfHit: Int, val prizeMoney: Int) {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun fromNumberOfHit(numberOfHit: Int): PrizeLevel {
            return values().firstOrNull { it.numberOfHit == numberOfHit } ?: NONE
        }
    }
}
