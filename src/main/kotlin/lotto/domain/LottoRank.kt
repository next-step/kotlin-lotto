package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val money: Int,
) {
    UNRANKED(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        fun findByMatchCountAndBonus(
            matchCount: Int,
            matchBonus: Boolean,
        ): LottoRank =
            when {
                matchCount == FIRST.matchCount -> FIRST
                matchCount == SECOND.matchCount && matchBonus -> SECOND
                matchCount == THIRD.matchCount -> THIRD
                matchCount == FOURTH.matchCount -> FOURTH
                matchCount == FIFTH.matchCount -> FIFTH
                else -> UNRANKED
            }

        fun associateWithCount(count: (LottoRank) -> Int) =
            LottoRank.entries.associateWith { rank ->
                count(rank)
            }
    }
}
