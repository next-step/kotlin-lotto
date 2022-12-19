package lotto.domain.policy

import lotto.common.value.Money
import lotto.common.value.Money.Companion.toMoney

sealed interface PricePolicy {
    fun apply(): Money
}

object DefaultPricePolicy : PricePolicy {

    private const val DEFAULT_PRICE = 1000L

    override fun apply(): Money {
        return DEFAULT_PRICE.toMoney()
    }
}
