package lotto.domain

enum class LottoRank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun getRank(matchCount: Int) = when (matchCount) {
            6 -> FIRST
            5 -> SECOND
            4 -> THIRD
            3 -> FOURTH
            else -> MISS
        }
    }
}
