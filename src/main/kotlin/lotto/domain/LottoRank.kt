package lotto.domain

enum class LottoRank(val rank: Int, val prize: Int, val description: String, val matchCount: Int) {
    FIRST(1, 2_000_000_000, "6개 일치", 6),
    SECOND(2, 1_500_000, "5개 일치", 5),
    THIRD(3, 50_000, "4개 일치", 4),
    FOURTH(4, 5_000, "3개 일치", 3),
    NO_RANK(5, 0, "꽝", 0),
    ;

    companion object {
        private val matchCountToRankMap = entries.associateBy { it.matchCount }

        fun fromMatchCount(lineMatchCount: Int): LottoRank {
            return matchCountToRankMap[lineMatchCount] ?: NO_RANK
        }
    }
}
