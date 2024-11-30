package lotto.util

import kotlin.random.Random

class RandomNumberGenerator(
    from: Int = 1,
    until: Int = 99,
) : NumberGenerator {
    private val randomNumbers = List(100) { Random.nextInt(from, until) }

    override fun getNumbers(count: Int): List<Int> {
        return randomNumbers.shuffled().take(count)
    }
}
