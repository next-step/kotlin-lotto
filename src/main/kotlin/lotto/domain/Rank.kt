package lotto.domain

enum class Rank(
    val matchCount: Int,
    val winningMoney: Long,
    val matchBonus: Boolean
) {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),

    MISS(0, 0, false);

    companion object {
        fun find(matchCount: Int, matchBonus: Boolean): Rank {
            return values().firstOrNull {
                it.matchCount == matchCount && (!it.matchBonus || matchBonus)
            } ?: MISS
        }

        val MATCH_RANKS: List<Rank> = values().filterNot { it == MISS }.toList()
    }
}
