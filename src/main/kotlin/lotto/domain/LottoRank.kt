package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val prize: Int,
) {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    BLANK_PLACE(0, 0), ;

    companion object {
        fun getRank(matchedCount: Int): LottoRank {
            return entries.find { it.matchCount == matchedCount } ?: BLANK_PLACE
        }
    }
}
