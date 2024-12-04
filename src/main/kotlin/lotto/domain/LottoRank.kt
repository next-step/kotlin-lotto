package lotto.domain

enum class LottoRank(val matchCount: Int, val prize: Long) {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    NONE(0, 0L),
    ;

    fun calculatePrize(count: Int): Long = prize * count
}
