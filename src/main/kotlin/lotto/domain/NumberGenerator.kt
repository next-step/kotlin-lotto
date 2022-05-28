package lotto.domain

class NumberGenerator(range: IntRange) {

    private val numbers: List<Int>

    init {
        numbers = range.toList()
    }

    fun randomTake(count: Int): List<Int> {
        return numbers
            .shuffled()
            .take(count)
    }

}
