package lotto.util

object RandomUtil {
    fun generateNumbers(intRange: IntRange, size: Int): List<Int> {
        return intRange.shuffled().take(size)
    }
}
