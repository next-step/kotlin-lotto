package lotto.domain

enum class LottoRank(val matchCount: Int, val winningMoney: Int) {
    FIRST_PLACE(matchCount = 6, winningMoney = 2000000000),
    SECOND_PLACE(matchCount = 5, winningMoney = 1500000),
    THIRD_PLACE(matchCount = 4, winningMoney = 50000),
    FOURTH_PLACE(matchCount = 3, winningMoney = 5000);

    companion object {
        fun selectByMatchCount(matchCount: Int): LottoRank? {
            return LottoRank.values().find { it.matchCount == matchCount }
        }
    }
}
