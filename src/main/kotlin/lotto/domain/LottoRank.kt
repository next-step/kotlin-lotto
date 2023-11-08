package lotto.domain

enum class LottoRank(
    val countOfMatch: Int,
    val winningMoney: Int,
) {

    MISS(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    ;

    fun isMiss(): Boolean =
        this == MISS

    companion object {
        fun from(matchCount: Int): LottoRank {
            return values().firstOrNull { it.countOfMatch == matchCount } ?: MISS
        }
    }
}
