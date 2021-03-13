package domain

import kotlin.random.Random

class RandomNumbers: Numbers {
    override fun makeNumber(min: Int, max: Int): Int {
        return Random.nextInt(min, max)
    }
}
