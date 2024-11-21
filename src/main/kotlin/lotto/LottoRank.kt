package lotto

enum class LottoRank(val prize: Int) {
    FIRST(2_000_000_000),
    SECOND(1_500_000),
    THIRD(50_000),
    FOURTH(5_000),
    NO_RANK(0),
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
