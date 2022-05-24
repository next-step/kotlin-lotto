package lotto

enum class LottoWinnerRank(val matchCount: Int, val price: Int) {
    FIRST_PRICE(6, 2_000_000_000),
    SECOND_PRICE(5, 30_000_000),
    THIRD_PRICE(5, 1_500_000),
    FOURTH_PRICE(4, 50_000),
    FIFTH_PRICE(3, 5_000),
    NONE(-1, 0),
    ;

    companion object {
        fun getRank(matchNumberCount: Int, hasBonusNumber: Boolean): LottoWinnerRank {
            return when (matchNumberCount) {
                6 -> FIRST_PRICE
                5 -> if (hasBonusNumber) SECOND_PRICE else THIRD_PRICE
                4 -> FOURTH_PRICE
                3 -> FIFTH_PRICE
                else -> NONE
            }
        }

        fun getRankingList(): List<LottoWinnerRank> {
            return values()
                .filter { it != NONE }
                .sortedBy { it.matchCount }
        }
    }
}
