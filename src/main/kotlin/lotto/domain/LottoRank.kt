package lotto.domain

enum class LottoRank(val rank: Int, val prize: Int, val description: String) {
    FIRST(1, 2_000_000_000, "6개 일치"),
    SECOND(2, 1_500_000, "5개 일치"),
    THIRD(3, 50_000, "4개 일치"),
    FOURTH(4, 5_000, "3개 일치"),
    NO_RANK(5, 0, "꽝"),
    ;

    companion object {
        fun fromMatchCount(matchCount: Int): LottoRank {
            return when (matchCount) {
                6 -> FIRST
                5 -> SECOND
                4 -> THIRD
                3 -> FOURTH
                else -> NO_RANK
            }
        }
    }
}
