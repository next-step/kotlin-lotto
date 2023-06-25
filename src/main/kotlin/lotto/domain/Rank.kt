package lotto.domain

enum class Rank(
    val matchCount: Int,
    val winningMoney: Long,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    fun isSecond(): Boolean = this === SECOND

    fun isNone() = this === NONE

    companion object {
        fun determineRank(intersectCount: Int, winningNumber: WinningNumber, lotto: Lotto): Rank? {
            return values().find {
                intersectCount == it.matchCount &&
                        (winningNumber.bonusNumber in lotto.lottoNumbers || it != SECOND)
            }
        }
    }
}

