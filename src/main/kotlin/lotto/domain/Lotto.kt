package lotto.domain

class Lotto {
    private val numberRange: IntRange = (1..45)
    private val totalNumbers: List<Int> = numberRange.shuffled()

    val numbers: List<Int> = totalNumbers.take(NUMBER_COUNT)

    companion object {
        const val PRICE = 1000
        private const val NUMBER_COUNT = 6
    }
}
