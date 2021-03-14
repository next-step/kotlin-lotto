package domain

import kotlin.random.Random

class RandomNumbers: Numbers {
    fun makeNumbers(min: Int, max: Int, size: Int): List<Int> {
        return (1..size).map { Random.nextInt(min, max)} }

    override fun makeNumber(min: Int, max: Int): Int {
        return Random.nextInt(min, max)
    }
}
