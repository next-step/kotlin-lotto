package lotto.domain

enum class LottoPrizeInfo(val matchCount: Int, val money: Int) {
    WIN3(3, 5000),
    WIN4(4, 50000),
    WIN5(5, 1500000),
    WIN5_BONUS(5, 30000000),
    WIN6(6, 2000000000);

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
