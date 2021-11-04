package domain.lotto.domain

enum class MatchBoard(val rank: Rank, val matchPrize: Int) {
    FIRST(Rank(6), 2_000_000_000),
    SECOND(Rank(5, true), 30_000_000),
    THIRD(Rank(5), 1_500_000),
    FOURTH(Rank(4), 50_000),
    FIFTH(Rank(3), 5_000),
    MISS(Rank(0), 0);

    companion object {
        fun values(numberOfMatch: Int, isMatchBonus: Boolean): MatchBoard =
            values().find {
                it.rank.isEqualToNumberOfMatch(numberOfMatch) && it.rank.isEqualToNecessityOfBonus(isMatchBonus)
            } ?: MISS

        fun valuesExcludedMiss(): List<MatchBoard> = values().filterNot { it == MISS }.reversed()
    }
}
