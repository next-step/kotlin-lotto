package lotto.domain

enum class PrizeLevel(val numberOfHit: Int, val prizeMoney: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    companion object {
        fun fromNumberOfHit(numberOfHit: Int): PrizeLevel {
            return values().firstOrNull { it.numberOfHit == numberOfHit } ?: NONE
        }

        fun countPrizeLevels(prizeLevels: List<PrizeLevel>): Map<PrizeLevel, Int> {
            return prizeLevels.groupingBy { it }.eachCount()
        }
    }
}
