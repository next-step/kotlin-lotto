package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val money: Int,
) {
    UNRANKED(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        fun from(matchCount: Int) = LottoRank.entries.find { it.matchCount == matchCount } ?: UNRANKED

        fun associateWithCount(count: (LottoRank) -> Int) =
            LottoRank.entries.associateWith { rank ->
                count(rank)
            }
    }
}
