package lotto.domain

enum class LottoPrize(private val count: Int, val reward: Int) {

    FIRST_PRIZE(6, 2_000_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    WHACK(0, 0);

    companion object {
        fun match(lotto: Lotto, winningLotto: WinningLotto): LottoPrize {
            val matchedCount = winningLotto.matchCount(lotto)
            return values().firstOrNull { it.count == matchedCount } ?: WHACK
        }
    }
}
