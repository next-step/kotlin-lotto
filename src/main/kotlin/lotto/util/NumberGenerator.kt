package lotto.util

class NumberGenerator {
    fun random(start: Int, end: Int, size: Int): List<Int> {
        val range = start..end
        val shuffled = range.shuffled()
        return shuffled.subList(0, size)
    }
}
