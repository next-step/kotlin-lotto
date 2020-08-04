package lotto.domain

enum class PrizeMoney(val money: Int, val ranking: String) {
    THREE_MONEY(5_000, "5등"),
    FOUR_MONEY(50_000, "4등"),
    FIVE_MONEY(1_500_000, "3등"),
    BONUS_FIVE_MONEY(300_000_000, "2등"),
    SIX_MONEY(2_000_000_000, "1등");

    fun totalMoney(number: Int): Int = money * number
}
