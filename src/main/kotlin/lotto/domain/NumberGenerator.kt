package lotto.domain

class NumberGenerator(range: IntRange) {
    private val numbers: List<Int>

    init {
        numbers = range.toList()
    }

    constructor(start: Int, end: Int) : this(start..end)

    fun randomTake(count: Int): List<Int> = numbers.shuffled().take(count)
}
