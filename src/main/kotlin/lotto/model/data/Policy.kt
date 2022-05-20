package lotto.model.data

interface Policy {
    val rangeOfNumbers: IntRange
    val countOfNumberToSelect: Int
    val priceOfLotto: Int
    val limitAmountToPurchase: Int
        get() = Int.MAX_VALUE

    fun validateNumbers(numbers: Collection<Int>) {
        require(numbers.size == countOfNumberToSelect)
        require(numbers.none { it !in rangeOfNumbers })
    }
}
