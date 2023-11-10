package lotto.domain

enum class LottoRank(
    val winningMatchCount: Int,
    val winningMoney: Int,
) {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    fun isMiss(): Boolean =
        this == MISS

    companion object {

        fun from(matchCount: Int): LottoRank {
            require(matchCount in MISS.winningMatchCount..FIRST.winningMatchCount) {
                "당첨 번호와 일치하는 개수는 0개 이상, 6개 이하만 가능합니다."
            }
            return values().firstOrNull { it.winningMatchCount == matchCount } ?: MISS
        }
    }
}
