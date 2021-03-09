package lotto.domain

enum class LottoRank(val matchCount: Int) {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    FAIL(0);

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
