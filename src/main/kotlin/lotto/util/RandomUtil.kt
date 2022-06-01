package lotto.util

object RandomUtil {
    fun numbersInRange(intRange: IntRange, size: Int): List<Int> {
        return intRange.shuffled().take(size)
    }
}
