package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val price: Int,
) {

    NONE(0, 0),
    MATCH_THREE(3, 5_000),
    MATCH_FOUR(4, 50_000),
    MATCH_FIVE(5, 1_500_000),
    MATCH_SIX(6, 2_000_000_000);

    companion object {
        fun getByMatchCount(matchCount: Int): LottoRank {
            return values().firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}
