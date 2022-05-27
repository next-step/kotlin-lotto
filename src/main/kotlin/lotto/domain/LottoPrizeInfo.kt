package lotto.domain

enum class LottoPrizeInfo(val matchCount: Int, val money: UserMoney, val isBonus: Boolean) {
    WIN3(3, UserMoney(5000), false),
    WIN4(4, UserMoney(50000), false),
    WIN5(5, UserMoney(1500000), false),
    WIN5_BONUS(5, UserMoney(30000000), true),
    WIN6(6, UserMoney(2000000000), false);

    companion object {
        fun getPrizeInfo(matchCount: Int, isBonus: Boolean): LottoPrizeInfo? {
            return values().firstOrNull { it.matchCount == matchCount && it.isBonus == isBonus }
        }
    }
}
