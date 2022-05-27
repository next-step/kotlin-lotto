package lotto

enum class LottoRank(val matchCount: Int, val price: Long) {
    SIX_MATCH(6, 2_000_000_000L),
    FIVE_MATCH(5, 1_500_000L),
    FOUR_MATCH(4, 50_000L),
    THREE_MATCH(3, 5_000L),
    LOSE(0, 0);

    companion object {

        fun selectRank(matchCount: Int): LottoRank {
            return values().find { it.matchCount == matchCount } ?: LOSE
        }
    }
}
