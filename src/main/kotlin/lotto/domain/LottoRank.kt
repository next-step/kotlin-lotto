package lotto.domain

enum class LottoRank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5000),
    NONE(0, 0),
    ;

    companion object {
        fun from(matchCount: Int): LottoRank {
            return entries.find { it.matchCount == matchCount } ?: NONE
        }
    }
}
