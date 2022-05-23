package lotto.domain

enum class WinCondition(val matchCount: Int, val price: Int) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    companion object {
        fun toWinPolicy(): List<WinPolicy> =
            WinCondition.values().map { WinPolicy(it.matchCount, Money(it.price)) }
    }
}
