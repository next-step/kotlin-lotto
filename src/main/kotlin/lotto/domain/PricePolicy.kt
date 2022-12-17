package lotto.domain

import lotto.common.Money

sealed interface PricePolicy {
    fun apply(): Money
}

class DefaultPricePolicy : PricePolicy {

    override fun apply(): Money {
        return Money.from(DEFAULT_PRICE)
    }

    private companion object {
        const val DEFAULT_PRICE = 1000L
    }
}