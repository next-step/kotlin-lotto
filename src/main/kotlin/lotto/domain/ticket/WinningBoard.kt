package lotto.domain.ticket

enum class WinningBoard(
    val matchCount: Int,
    val reward: Long
) {
    NONE(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 150_000),
    FIVE_WITH_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000),
    ;

    fun times(amount: Int): Long {
        return reward.times(amount)
    }

    fun upgrade(isBonusMatch: Boolean) =
        if (isBonusMatch && this == FIVE) {
            FIVE_WITH_BONUS
        } else {
            this
        }

    companion object {
        fun findBy(matchCount: Int) = values().find { it.matchCount == matchCount }
            ?: NONE
    }
}
