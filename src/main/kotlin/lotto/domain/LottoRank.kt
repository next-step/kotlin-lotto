package lotto.domain

enum class LottoRank(
    val matchCount: Int?,
    val price: Int
) {
    NONE(null, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    companion object {
        fun getLottoRankByMatchCount(count: Int): LottoRank {
            return LottoRank.values().find { it.matchCount == count } ?: NONE
        }
    }
}