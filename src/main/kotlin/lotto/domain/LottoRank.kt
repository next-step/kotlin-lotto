package lotto.domain

enum class LottoRank(val matchingCount: Int, val reward: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    UNRANKED(-1, 0);

    companion object {
        fun valueOf(matchingCount: Int): LottoRank {
            return values().find { it.matchingCount == matchingCount } ?: UNRANKED
        }
    }
}
