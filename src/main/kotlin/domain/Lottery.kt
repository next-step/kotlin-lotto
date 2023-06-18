package domain

import util.NumberGenerator
import util.RandomNumberGenerator

class Lottery(numberGenerator: NumberGenerator = RandomNumberGenerator) {

    val randomNumbers = numberGenerator.randomNumbers()

    fun countMatchingLottery(winningNums: Set<Int>): Int {
        return randomNumbers.intersect(winningNums).size
    }
}
