package lotto.domain

enum class LottoPrizeInfo(val matchCount: Int, val money: UserMoney) {
    WIN3(3, UserMoney(5000)),
    WIN4(4, UserMoney(50000)),
    WIN5(5, UserMoney(1500000)),
    WIN5_BONUS(5, UserMoney(30000000)),
    WIN6(6, UserMoney(2000000000));

    fun isBonus(): Boolean {
        return this == WIN5_BONUS
    }

    companion object {
        fun getPrizeInfo(matchCount: Int, isBonus: Boolean): LottoPrizeInfo? {
            val matchPrizeInfo = values().firstOrNull { it.matchCount == matchCount }

            if (matchPrizeInfo == WIN5 && isBonus) {
                return WIN5_BONUS
            }

            return matchPrizeInfo
        }
    }
}
