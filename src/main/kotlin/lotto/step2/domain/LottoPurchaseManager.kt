package lotto.step2.domain

import lotto.step2.domain.Lotto.Companion.PRICE

class LottoPurchaseManager(
    private val numberPicker: NumberPicker,
) {
    fun purchase(money: Long): List<Lotto> {
        val availableCount = this.getAvailableCount(money)

        return (1..availableCount).map {
            Lotto.of(pickNumbers = numberPicker.pick())
        }
    }

    private fun getAvailableCount(money: Long): Long {
        return money / PRICE
    }
}
