package lotto.domain

class Lotto {
    private val numberRange: IntRange = (MIN_NUMBER..MAX_NUMBER)
    private val totalNumbers: List<Int> = numberRange.shuffled()

    val numbers: List<Int> = totalNumbers.take(NUMBER_COUNT)
        .sorted()

    fun getMatchedNumberCount(winningNumbers: List<Int>): Int {
        return numbers.toSet()
            .intersect(winningNumbers.toSet())
            .count()
    }

    companion object {
        const val PRICE = 1000L
        private const val NUMBER_COUNT = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}
