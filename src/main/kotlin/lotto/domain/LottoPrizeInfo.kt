package lotto.domain

enum class LottoPrizeInfo(val matchCount: Int, val money: Money, val isBonus: Boolean) {
    WIN3(3, Money(5000), false),
    WIN4(4, Money(50000), false),
    WIN5(5, Money(1500000), false),
    WIN5_BONUS(5, Money(30000000), true),
    WIN6(6, Money(2000000000), false);

    companion object {
        fun getPrizeInfo(matchCount: Int, isBonus: Boolean): LottoPrizeInfo? {
            return values().firstOrNull { it.matchCount == matchCount && it.isBonus == isBonus }
        }

        fun getEmptyResult() = values().map { LottoResult(it) }
    }
}
