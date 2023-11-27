package lotto

import kotlin.random.Random

class LottoGenerator {
    fun generate(): Set<Int> {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < LIMIT_SIZE) {
            numbers.add(Random.nextInt(MAXIMUM))
        }
        return numbers
    }
    
    companion object {
        private const val MAXIMUM = 45
        private const val LIMIT_SIZE = 6 
    }
}
