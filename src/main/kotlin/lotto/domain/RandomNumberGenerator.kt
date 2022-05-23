package lotto.domain

object RandomNumberGenerator {
    fun getRandomNumbers(range: IntRange, n: Int): List<Int> {
        return range.toList().shuffled().take(n)
    }
}
