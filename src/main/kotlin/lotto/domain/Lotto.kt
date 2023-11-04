package lotto.domain

class Lotto {
    private val numberRange: IntRange = (1..45)
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
    }
}
