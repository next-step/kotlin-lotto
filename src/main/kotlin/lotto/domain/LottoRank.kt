package lotto.domain

enum class LottoRank(
    val rankName: String,
    val numOfMatch: Int,
    val winningMoney: Int
) {
    FIRST("1등", 6, 2000000000),
    SECOND("2등", 5, 1500000),
    THIRD("3등", 4, 50000),
    FOURTH("4등", 3, 5000);

    companion object {
        const val DEFAULT_MONEY = 0

        fun rankOfMatchedNum(numOfMatch: Int): LottoRank? {
            return values().find { it.numOfMatch == numOfMatch }
        }

        fun ranks(): List<LottoRank> {
            return values().sortedByDescending { it.numOfMatch }
        }
    }
}
