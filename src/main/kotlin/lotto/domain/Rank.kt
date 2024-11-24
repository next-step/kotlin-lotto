package lotto.domain

enum class Rank(
    val countOfMatch: Int,
    val isMatchBonusNeed: Boolean,
    val winningMoney: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0), ;

    companion object {
        fun valueOf(
            countOfMatch: Int,
            matchBonus: Boolean,
        ): Rank {
            if (matchBonus) {
                entries.find { it.countOfMatch == countOfMatch && it.isMatchBonusNeed }
                    ?: entries.find { it.countOfMatch == countOfMatch } ?: MISS
            }
            return entries.filter { !it.isMatchBonusNeed }.find { it.countOfMatch == countOfMatch } ?: MISS
        }

        fun getRankCount(
            rank: Rank,
            ranks: List<Rank>,
        ): Int {
            return ranks.filter { it.equals(rank) }.size
        }
    }
}
