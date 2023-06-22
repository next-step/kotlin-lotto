package domain

import util.NumberGenerator
import util.RandomNumberGenerator

class Lottery(numberGenerator: NumberGenerator = RandomNumberGenerator) {

    val lotteryNumbers = numberGenerator.randomNumbers()

    fun matchedCount(winningNums: Set<Int>): Int {
        return lotteryNumbers.intersect(winningNums).size
    }

    fun containBonusBall(bonusBall: Int): Boolean {
        return lotteryNumbers.contains(bonusBall)
    }
}
