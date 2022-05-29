package lotto.domain

enum class WinCondition(val matchCount: Int, val price: Int, val bonus: Boolean = false) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000);

    companion object {
        fun toWinPolicy(): List<WinPolicy> =
            values().map { WinPolicy(it.matchCount, Money(it.price), it.bonus) }
    }
}
