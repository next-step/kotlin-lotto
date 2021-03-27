package lotto.result

enum class Rank(
    val matchCount: Int,
    val prizeAmount: Long
) {
    FAIL(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    BONUS_SECOND(5, 3_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        val WINNING_RANKS: List<Rank> = values().filter { FAIL != it }
            .sortedBy { it.matchCount }

        private fun findByMatchCount(matchCount: Int) = values().find {
            it.matchCount == matchCount
        } ?: FAIL

        /*
        * step1지원을 위해 퍼블릭 인터페이스 유지
        * */
        fun ofMatchCount(matchCount: Int): Rank = when (val rank = findByMatchCount(matchCount)) {
            BONUS_SECOND -> SECOND
            else -> rank
        }

        fun ofMatchInfo(matchCount: Int, hasBonusBall: Boolean): Rank {
            val rank = ofMatchCount(matchCount)
            if (rank == SECOND && hasBonusBall) {
                return BONUS_SECOND
            }
            return rank
        }
    }
}
