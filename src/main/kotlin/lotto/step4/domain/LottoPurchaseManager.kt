package lotto.step4.domain

class LottoPurchaseManager(
    private val numberPicker: NumberPicker,
) {
    fun purchase(money: Money): List<Lotto> {
        val availableCount = this.getAvailableCount(money)

        return (1..availableCount).map {
            Lotto.of(numbers = numberPicker.pick())
        }
    }

    private fun getAvailableCount(money: Money): Long {
        return money.div(LOTTO_PRICE)
    }

    companion object {
        val LOTTO_PRICE = Money(1000L)
    }
}
