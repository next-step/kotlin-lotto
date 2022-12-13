package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val matchBonus: Boolean,
    val winning: Long
) {
    FIRST(6, false, 20_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoRank {
            return values().find { it.matchCount == matchCount && (it.matchBonus.not() || matchBonus) }
                ?: NONE
        }
    }
}
