package lotto

enum class LottoRanking(val matchCount: Int, val winningAmount: Int) {
    FIRST_ST(6, 2_000_000_000),
    TWO_ND(5, 1_500_000),
    THREE_RD(4, 50_000),
    FOUR_TH(3, 5_000),
    OUT_OF_RAKING(0, 0),
    ;

    companion object {
        fun getRankingByMatchCount(matchCount: Int): LottoRanking = when (matchCount) {
            FIRST_ST.matchCount -> FIRST_ST
            TWO_ND.matchCount -> TWO_ND
            THREE_RD.matchCount -> THREE_RD
            FOUR_TH.matchCount -> FOUR_TH
            else -> OUT_OF_RAKING
        }
    }
}
