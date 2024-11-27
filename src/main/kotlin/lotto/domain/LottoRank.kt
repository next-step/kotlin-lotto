package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val prize: Int,
    val matchBonus: Boolean = false,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5000),
    NONE(0, 0),
    ;

    companion object {
        fun from(
            matchCount: Int,
            matchBonus: Boolean,
        ): LottoRank {
            return entries.find { it.matchCount == matchCount && (!it.matchBonus || matchBonus) } ?: NONE
        }
    }
}
