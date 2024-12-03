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
        fun from(
            matchCount: Int,
            matchBonus: Boolean,
        ) = LottoRank.entries.find {
            if (matchCount == SECOND.matchCount && matchBonus) {
                it == SECOND
            } else {
                it.matchCount == matchCount
            }
        } ?: UNRANKED

        fun associateWithCount(count: (LottoRank) -> Int) =
            LottoRank.entries.associateWith { rank ->
                count(rank)
            }
    }
}
