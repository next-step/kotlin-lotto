package lotto.service

import lotto.domain.Numbers

class AutoNumberCreateStrategy : NumberCreateStrategy {

    override fun makeNumbersByQuantity(quantity: Int): List<Numbers> {
        return List(quantity) {
            makeNumbers()
        }
    }

    private fun makeNumbers() = Numbers(
        (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled()
            .subList(0, NUMBER_COUNT)
    )

    companion object {
        private const val NUMBER_COUNT: Int = 6
        private const val MINIMUM_NUMBER: Int = 1
        private const val MAXIMUM_NUMBER: Int = 45
    }
}
