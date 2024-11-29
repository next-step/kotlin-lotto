package lotto.util

import kotlin.random.Random

class RandomNumberGenerator(
    from: Int = 1,
    until: Int = 99
) {
    private val randomNumbers = listOf(Random.nextInt(from, until))

    fun getRandomNumbers(count: Int): List<Int> {
        return randomNumbers.shuffled().take(count)
    }
}