package lotto.result

enum class Rank(
    val matchCount: Int,
    val prizeAmount: Long
) {
    FAIL(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    companion object {
        val WINNING_RANKS: List<Rank> = values().filter { FAIL != it }
            .sortedBy { it.matchCount }

        fun ofMatchCount(matchCount: Int): Rank {
            return values().find { it.matchCount == matchCount } ?: FAIL
        }
    }
}
