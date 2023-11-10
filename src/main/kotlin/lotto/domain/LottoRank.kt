package lotto.domain

enum class LottoRank(
    val winningMatchCount: Int,
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
            require(matchCount in MISS.winningMatchCount..SIX.winningMatchCount) {
                "당첨 번호와 일치하는 개수는 0개 이상, 6개 이하만 가능합니다."
            }
            return values().firstOrNull { it.winningMatchCount == matchCount } ?: MISS
        }
    }
}
