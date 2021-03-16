package lotto.result

enum class PrizeRank(
    val matchCount: Int,
    val prizeAmount: Prize
) {
    FAIL(0, Prize(0)),
    FOURTH(3, Prize(5_000)),
    THIRD(4, Prize(50_000)),
    SECOND(5, Prize(1_500_000)),
    FIRST(6, Prize(2_000_000_000));

    companion object {
        val WINNING_PRIZE_RANKS: List<PrizeRank> = values().filter { FAIL != it }

        fun ofMatchCount(matchCount: Int): PrizeRank {
            return values().find { it.matchCount == matchCount } ?: FAIL
        }
    }
}