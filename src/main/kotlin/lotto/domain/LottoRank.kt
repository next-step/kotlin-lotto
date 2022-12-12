package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val winning: Long
) {
    FIRST(6, 20_000_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    NONE(0, 0L);

    companion object {
        fun of(matchCount: Int): LottoRank {
            return values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}
