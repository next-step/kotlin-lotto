package lotto.domain

enum class PrizeMoney(val money: Int, val ranking: String) {
    THREE_MONEY(5000, "4등"),
    FOUR_MONEY(50000, "3등"),
    FIVE_MONEY(1500000, "2등"),
    SIX_MONEY(2000000000, "1등");

    fun totalMoney(number: Int): Int = money * number
}
