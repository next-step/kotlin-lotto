package lotto.domain

open class RandomNumberGenerator {
    fun getRandomNumbers(range: IntRange, n: Int): List<Int> {
        return range.toList().shuffled().take(n)
    }
}
