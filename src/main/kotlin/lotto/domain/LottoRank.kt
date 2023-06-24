package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val price: Int,
) {

    NONE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun getByMatchCount(matchCount: Int): LottoRank {
            return values().firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}
