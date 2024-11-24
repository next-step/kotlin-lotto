package lotto.domain

enum class LottoRank(val matchCount: Int, val winningAmount: Int) {
    NONE(0, 0),
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    companion object {
        fun of(matchCount: Int): LottoRank = LottoRank.entries.find { it.matchCount == matchCount } ?: NONE
    }
}
