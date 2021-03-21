package lotto.domain

enum class LottoRank(val matchCount: Int, val winningPrice: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FAIL(0, 0);

    companion object {
        fun matchRank(matchCount: Int): LottoRank {
            return when (matchCount) {
                FIRST.matchCount -> FIRST
                SECOND.matchCount -> SECOND
                THIRD.matchCount -> THIRD
                FOURTH.matchCount -> FOURTH
                else -> FAIL
            }
        }
    }
}
