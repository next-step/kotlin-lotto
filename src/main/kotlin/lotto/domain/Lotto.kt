package lotto.domain

data class Lotto(
    val numbers: List<Int>,
    val price: Price = Price.NONE
) {

    init {
        require(numbers.all { isInRange(it) } && numbers.size == LOTTO_NUMBER_COUNT) {
            "Lotto should have 6 numbers between 1 to 45"
        }
    }

    constructor(vararg numbers: Int) : this(numbers.toList())

    fun winnerPrize(): Int = price.winningPrize

    private fun isInRange(number: Int): Boolean {
        return LOTTO_NUMBER_RANGE.contains(number)
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_COUNT = 6
    }
}
