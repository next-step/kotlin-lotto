package lotto.domain

class LottoPurchaseManager(
    private val numberPicker: NumberPicker,
) {
    fun purchase(money: Long): List<Lotto> {
        val availableCount = money / LOTTO_PRICE

        return (1..availableCount).map {
            Lotto.of(pickNumbers = numberPicker.pick())
        }
    }

    companion object {
        private const val LOTTO_PRICE = 1000L
    }
}
