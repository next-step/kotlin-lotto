package lotto.domain

enum class LottoWinInfo(val matchCount: Int, val money: Int) {
    WIN3(3, 5000),
    WIN4(4, 50000),
    WIN5(5, 1500000),
    WIN6(6, 2000000000);

    companion object {
        fun getWinnerInfo(matchCount: Int): LottoWinInfo? {
            return values().firstOrNull {
                it.matchCount == matchCount
            }
        }
    }
}