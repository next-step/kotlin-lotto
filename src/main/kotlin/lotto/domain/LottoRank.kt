package lotto.domain

enum class LottoRank(
    val rankName: String,
    val numOfMatch: Int,
    val isBonusMatched: Boolean,
    val winningMoney: Int
) {
    FIRST("1등", 6, false, 2000000000),
    SECOND("2등", 5, true, 30000000),
    THIRD("3등", 5, false, 1500000),
    FOURTH("4등", 4, false, 50000),
    FIFTH("5등", 3, false, 5000);

    companion object {
        const val DEFAULT_MONEY = 0

        fun of(numOfMatch: Int, isBonusMatched: Boolean): LottoRank? {
            return when {
                numOfMatch == 5 && !isBonusMatched -> THIRD
                else -> values().find { it.numOfMatch == numOfMatch }
            }
        }

        fun ranks(): List<LottoRank> {
            return values().sortedWith(
                compareBy<LottoRank> { it.numOfMatch }
                    .thenBy { it.isBonusMatched })
        }
    }
}
