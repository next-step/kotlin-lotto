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
    MISS(0, 0),

    ;

    fun isMiss() =
        this == MISS

    fun isSecond() =
        this == SECOND

    companion object {

        fun from(matchCount: Int, hasBonusBall: Boolean): LottoRank {
            validateRange(matchCount)
            return when {
                matchCount == SECOND.winningMatchCount && hasBonusBall -> SECOND
                matchCount == SECOND.winningMatchCount && hasBonusBall.not() -> THIRD
                else -> values().firstOrNull { it.winningMatchCount == matchCount } ?: MISS
            }
        }

        private fun validateRange(matchCount: Int) {
            require(matchCount in MISS.winningMatchCount..FIRST.winningMatchCount) {
                "당첨 번호와 일치하는 개수는 0개 이상, 6개 이하만 가능합니다."
            }
        }
    }
}
