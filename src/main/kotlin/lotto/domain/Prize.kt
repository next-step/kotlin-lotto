package lotto.domain

enum class Prize(val prize: Int, val match: Int) {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NO_PRIZE(0, -1);

    companion object {
        private const val SECOND_THIRD_MATCH_NUM = 5
        private val prizeMap = Prize.values().associateBy { it.match }

        fun getPrize(matchNum: Int, bonus: Boolean): Prize {
            if (matchNum == SECOND_THIRD_MATCH_NUM && bonus) {
                return SECOND
            }

            return prizeMap[matchNum] ?: NO_PRIZE
        }
    }
}
