package lotto.domain

enum class LottoRank(
    val winningMatchCount: List<Int>,
    val winningMoney: Int,
) {

    FIRST(listOf(6), 2_000_000_000),
    SECOND(listOf(5), 30_000_000),
    THIRD(listOf(5), 1_500_000),
    FOURTH(listOf(4), 50_000),
    FIFTH(listOf(3), 5_000),
    MISS(listOf(0, 1, 2), 0),

    ;

    fun isMiss(): Boolean =
        this == MISS

    fun isSecond(): Boolean =
        this == SECOND

    companion object {

        fun from(matchCount: Int, hasBonusBall: Boolean): LottoRank {
            return when {
                isSecondOrThirdRank(matchCount) && hasBonusBall -> SECOND
                isSecondOrThirdRank(matchCount) && hasBonusBall.not() -> THIRD
                else -> entries.firstOrNull { it.winningMatchCount.contains(matchCount) }
                    ?: throw IllegalArgumentException("당첨 번호와 일치하는 개수는 ${MISS.winningMatchCount[0]}개 이상, ${FIRST.winningMatchCount[0]}개 이하만 가능합니다.")
            }
        }

        fun isSecondOrThirdRank(matchCount: Int): Boolean =
            SECOND.winningMatchCount.contains(matchCount)
    }
}
