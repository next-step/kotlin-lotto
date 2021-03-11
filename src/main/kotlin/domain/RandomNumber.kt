package domain

import java.util.stream.IntStream
import kotlin.random.Random
import kotlin.streams.toList

class RandomNumber {

    fun makeRandoms(size: Int): List<Int> {
        return IntStream.range(START_INDEX, size)
            .map { makeRandom() }
            .toList()
    }

    private fun makeRandom(): Int {
        return Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }

    companion object {
        private const val START_INDEX = 0
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 100
    }
}
