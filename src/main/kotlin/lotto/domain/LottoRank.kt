package lotto.domain

enum class LottoRank(val matchCount: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    OUT(0, 0);

    companion object {
        fun findRank(matchCount: Int): LottoRank {
            return values()
                .firstOrNull { it.matchCount == matchCount } ?: OUT
        }
    }
}
