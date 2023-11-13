package lotto.domain

import lotto.service.NumberCreateStrategy

class NumberCreateStrategyDouble(
    private val numbers: List<Numbers> = listOf()
) : NumberCreateStrategy {

    override fun makeNumbersByQuantity(quantity: Int): List<Numbers> {
        return numbers.subList(0, quantity)
    }
}