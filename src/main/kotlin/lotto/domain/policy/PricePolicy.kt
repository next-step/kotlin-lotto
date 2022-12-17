package lotto.domain.policy

import lotto.common.value.Money

sealed interface PricePolicy {
    fun apply(): Money
}

object DefaultPricePolicy : PricePolicy {

    private const val DEFAULT_PRICE = 1000L

    override fun apply(): Money {
        return Money.from(DEFAULT_PRICE)
    }
}