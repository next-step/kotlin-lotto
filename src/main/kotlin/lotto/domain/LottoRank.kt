package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val winning: Long
) {
    FIRST(6, 20_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    NONE(0, 0L);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoRank {
            if (SECOND.matchCount == matchCount && matchBonus) {
                return SECOND
            }

            return values().filter { it != SECOND }
                .find { it.matchCount == matchCount }
                ?: NONE
        }
    }
}
