package lotto.domain

enum class LottoRank(
    val rankName: String,
    val numOfMatch: Int?,
    val isBonusMatched: Boolean,
    val winningMoney: Int
) {
    FIRST("1등", 6, false, 2_000_000_000),
    SECOND("2등", 5, true, 30_000_000),
    THIRD("3등", 5, false, 1_500_000),
    FOURTH("4등", 4, false, 50_000),
    FIFTH("5등", 3, false, 5_000),
    NONE("꽝", null, false, 0);

    companion object {
        const val DEFAULT_MONEY = 0

        fun of(numOfMatch: Int, isBonusMatched: Boolean): LottoRank {
            return when {
                numOfMatch == 5 && !isBonusMatched -> THIRD
                else -> values().find { it.numOfMatch == numOfMatch } ?: NONE
            }
        }

        fun ranks(): List<LottoRank> {
            return values().sortedWith(
                Comparator<LottoRank> { a, b ->
                    when {
                        a.numOfMatch == null -> -1
                        b.numOfMatch == null -> 1
                        else -> a.numOfMatch.compareTo(b.numOfMatch)
                    }
                }.thenBy { it.isBonusMatched })
        }
    }
}
