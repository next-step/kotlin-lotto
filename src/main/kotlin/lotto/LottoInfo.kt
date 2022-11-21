package lotto

enum class LottoInfo(
    val matchCount: Int,
    val amount: Int,
) {
    NON_MATCH(0, 0),
    ONE_MATCH(1, 0),
    TWO_MATCH(2, 0),
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    companion object {
        private const val WINNER_MINIMUM_THRESH_HOLD = 3

        fun of(matchCount: Int): LottoInfo {
            return values().first { it.matchCount == matchCount }
        }

        fun winner(): List<LottoInfo> {
            return values().filter { it.matchCount >= WINNER_MINIMUM_THRESH_HOLD }
        }
    }
}
