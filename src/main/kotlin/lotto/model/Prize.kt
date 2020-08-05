package lotto.model

enum class Prize(val matchCount: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    BETWEEN_FIRST_AND_SECOND(5, 30_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0);

    companion object {
        fun findByMatchCount(matchCount: Int, matchedBonusNumber: Boolean): Prize {
            val prize = values().filter { it.matchCount == matchCount }

            return when (prize.size) {
                2 -> if (matchedBonusNumber) prize.first() else prize.last()
                1 -> prize.first()
                else -> NOTHING
            }
        }
    }
}
