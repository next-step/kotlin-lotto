package lotto.domain

data class Lotto(
    val numbers: List<Int>
) {

    init {
        require(numbers.all { isInRange(it) } && numbers.size == LOTTO_NUMBER_COUNT) {
            "Lotto should have 6 numbers between 1 to 45"
        }
    }

    constructor(vararg numbers: Int) : this(numbers.toList())

    fun correctNumberCounts(other: Lotto): Int =
        (numbers.sorted() zip other.numbers.sorted())
            .count { it.first == it.second }

    private fun isInRange(number: Int): Boolean {
        return number in LOTTO_NUMBER_RANGE
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        const val LOTTO_NUMBER_COUNT = 6
    }
}
