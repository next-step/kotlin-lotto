package lotto

import lotto.vo.Money

enum class WinningPrize(
    val condition: Int,
    val amount: Money,
) {
    MATCH_3(3, Money(5000)),
    MATCH_4(4, Money(50000)),
    MATCH_5(5, Money(1500000)),
    MATCH_6(6, Money(2000000000));

    companion object {
        fun from(matchingResult: Int): WinningPrize? {
            return WinningPrize
                .values()
                .firstOrNull { it.condition == matchingResult }
        }
    }
}
