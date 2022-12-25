package lotto.domain

enum class WinningAmount(
    val count: Int,
    val amount: Long,
    val isBonusBallMatched: Boolean = false,
) {
    ZERO(0, 0L),
    ONE(1, 0L),
    TWO(2, 0L),
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    FIVE_WITH_BONUS(5, 30000000L, true),
    SIX(6, 2000000000L);

    companion object {
        private const val MIN_COUNT = 3

        fun from(count: Int, isBonusBallMatched: Boolean): WinningAmount {
            if (count == FIVE.count && isBonusBallMatched) {
                return FIVE_WITH_BONUS
            }

            return values().find { it.count == count } ?: throw IllegalArgumentException("당첨 번호와 일치하는 개수가 올바르지 않습니다.")
        }

        fun findWinningPrize(): List<WinningAmount> {
            return values().filter { it.count >= MIN_COUNT }
        }
    }
}
