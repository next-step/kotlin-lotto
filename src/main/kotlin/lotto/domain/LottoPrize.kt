package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class LottoPrizes(val prizes: List<LottoPrize> = emptyList()) {
    private val prizeEachCountMap = prizes.groupingBy { it }.eachCount()

    val prizeResult = LottoPrize.values()
        .map { Pair(it, prizeEachCountMap.getOrDefault(it, 0)) }

    fun earnings(money: Money): Double {
        return BigDecimal(prizes.sumOf { it.price.amount })
            .divide(BigDecimal(money.amount), 2, RoundingMode.FLOOR)
            .toDouble()
    }
}

enum class LottoPrize(val matchCount: Int, val price: Money) {
    THIRD(3, Money(5_000)),
    FORTH(4, Money(50_000)),
    FIFTH(5, Money(1_500_000)),
    FIFTH_BONUS(6, Money(30_000_000)),
    SIXTH(6, Money(2_000_000_000));

    companion object {

        fun of(matchCount: Int, matchBonus: Boolean): LottoPrize? {
            return when (matchCount) {
                FIFTH.matchCount -> if (matchBonus) FIFTH_BONUS else FIFTH
                THIRD.matchCount -> THIRD
                FORTH.matchCount -> FORTH
                SIXTH.matchCount -> SIXTH
                else -> null
            }
        }
    }
}
