package lotto.domain

enum class PrizeLevel(val numberOfHit: Int, val prizeMoney: Int) {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun fromNumberOfHit(numberOfHit: Int): PrizeLevel {
            return values().firstOrNull { it.numberOfHit == numberOfHit } ?: NONE
        }

        fun countPrizeLevels(prizeLevels: List<PrizeLevel>): Map<PrizeLevel, Int> {
            val PrizeLeveMap = values()
                .filter { it != NONE }
                .associateWith { 0 }
                .toMutableMap()

            prizeLevels.forEach { it ->
                if (it != NONE) {
                    PrizeLeveMap[it] = PrizeLeveMap.getValue(it) + 1
                }
            }

            return PrizeLeveMap.toMap()
        }
    }
}
