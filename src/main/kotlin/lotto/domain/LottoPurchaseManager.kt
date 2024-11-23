package lotto.domain

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
        return money / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000L
    }
}
