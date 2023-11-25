package lotto.domain

enum class LottoPrize(
    val matchCount: Int,
    val prizeMoney: Long,
    val matchBonus: Boolean?,
) {

    FIRST(6, 2_000_000_000L, null),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000L, false),
    FOURTH(4, 50_000L, null),
    FIFTH(3, 5_000L, null),
    MISS(0, 0, null),
    ;

    companion object {

        fun of(matchCount: Int, matchBonus: Boolean = false): LottoPrize {
            return LottoPrize.values()
                .firstOrNull { it.matchCount == matchCount && (it.matchBonus == null || matchBonus == it.matchBonus) }
                ?: MISS
        }
    }
}
