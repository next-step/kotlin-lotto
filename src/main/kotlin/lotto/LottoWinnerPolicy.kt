package lotto

import lotto.money.Money

enum class LottoWinnerPolicy(matchCount: Int, val price: Money) {
    FIRST_PRICE(6, Money.of(2_000_000_000)),
    SECOND_PRICE(5, Money.of(1_500_000)),
    THIRD_PRICE(4, Money.of(50_000)),
    FOURTH_PRICE(3, Money.of(5_000)),
    NONE(-1, Money.of(0)),
    ;

    companion object {
        fun getRank(matchNumberCount: Int): LottoWinnerPolicy {
            return when (matchNumberCount) {
                6 -> FIRST_PRICE
                5 -> SECOND_PRICE
                4 -> THIRD_PRICE
                3 -> FOURTH_PRICE
                else -> NONE
            }
        }
    }
}
