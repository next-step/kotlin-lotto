package lotto.dto

private const val MINIMUM_WINNING_COUNT = 3

enum class LottoResult(
    val matchCount: Int,
    val winningMoney: Int
) {
    NO_MATCH(0, 0),
    MATCH_ONE_NUMBERS(1, 0),
    MATCH_TWO_NUMBERS(2, 0),
    MATCH_THREE_NUMBERS(3, 5000),
    MATCH_FOUR_NUMBERS(4, 50000),
    MATCH_FIVE_NUMBERS(5, 1500000),
    MATCH_SIX_NUMBERS(6, 2000000000);

    fun isWinning(): Boolean {
        return matchCount >= MINIMUM_WINNING_COUNT
    }

    companion object {
        fun fromMatchCount(count: Int): LottoResult {
            return values().first { it.matchCount == count }
        }

        fun winningValues(): List<LottoResult> {
            return values().filter { it.matchCount >= MINIMUM_WINNING_COUNT }
        }
    }
}