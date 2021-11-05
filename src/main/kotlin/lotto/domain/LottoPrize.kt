package lotto.domain

import lotto.domain.money.Money
import lotto.domain.money.Won

enum class LottoPrize(val matchCount: Int, val amount: Money) {
    FOURTH(3, Won(5_000)),
    THIRD(4, Won(50_000)),
    SECOND(5, Won(1_500_000)),
    FIRST(6, Won(2_000_000_000));

    companion object {
        fun fromMatchCount(matchCount: Int): LottoPrize? {
            return try {
                values().first { it.matchCount == matchCount }
            } catch (error: NoSuchElementException) {
                null
            }
        }
    }
}
