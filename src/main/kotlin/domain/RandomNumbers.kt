package domain

import kotlin.random.Random

class RandomNumbers: Numbers {

    override fun makeNumbers(size: Int): HashSet<Int> {
        return (START_INDEX..size)
            .map { makeNumber() }
            .toHashSet()
    }

    private fun makeNumber(): Int {
        return Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }

    companion object {
        private const val START_INDEX = 0
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 100
    }
}
