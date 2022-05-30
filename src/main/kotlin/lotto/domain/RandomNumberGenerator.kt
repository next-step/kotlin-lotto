package lotto.domain

class RandomNumberGenerator {
    fun getRandomNumbers(range: IntRange, n: Int): List<Int> {
        return range.toList().shuffled().take(n)
    }
}
