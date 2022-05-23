package lotto.model.data

interface Policy {
    val rangeOfNumbers: IntRange
    val countOfNumberToSelect: Int
    val priceOfLotto: Int
    val limitAmountToPurchase: Int
        get() = Int.MAX_VALUE
    val isManualPurchaseAllowed: Boolean
        get() = true

    fun validateNumbers(numbers: Collection<Int>) {
        require(numbers.size == countOfNumberToSelect)
        require(numbers.none { it !in rangeOfNumbers })
    }

    fun validateWinningNumbers(numbers: Collection<Int>, bonusNumber: Int) {
        validateNumbers(numbers)
        require(bonusNumber in this.rangeOfNumbers)
    }
}
