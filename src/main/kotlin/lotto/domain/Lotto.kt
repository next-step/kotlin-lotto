package lotto.domain

class Lotto(
    val numbers: List<Int> = LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_COUNT).sorted(),
) {
    fun calculateNumberOfMatchedNumbers(numbers: List<Int>): Int {
        return numbers.intersect(this.numbers).size
    }

    override fun toString(): String {
        return numbers.joinToString(", ", "[", "]")
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
        const val PRICE = 1000
    }
}
