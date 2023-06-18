package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val winningMoney: Int,
) {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    ;

    companion object {
        private val MAP_BY_MATCH_COUNT = values().associateBy { it.matchCount }

        fun of(matchCount: Int): LottoRank? {
            return MAP_BY_MATCH_COUNT[matchCount]
        }

        fun createMapWithLottoRankAndZero(): MutableMap<LottoRank, Int> {
            return values().associateWith { 0 }.toMutableMap()
        }
    }
}
