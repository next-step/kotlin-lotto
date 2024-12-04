package lotto.domain

enum class LottoRank(private val rank: Int, private val prize: Long) {
    FIRST(1, 2_000_000_000L),
    SECOND(2, 30_000_000L),
    THIRD(3, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(5, 5_000L),
    NONE(0, 0L),
    ;

    fun calculatePrize(count: Int): Long = prize * count
}
