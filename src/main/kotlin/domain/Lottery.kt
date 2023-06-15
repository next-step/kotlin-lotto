package domain

import util.NumberGenerator
import util.RandomNumberGenerator

class Lottery(numberGenerator: NumberGenerator = RandomNumberGenerator) {

    val randomNumber = numberGenerator.randomNumberGenerator()

    fun countMatchingLottery(winningNums: List<Int>): Int {
        return randomNumber.intersect(winningNums.toSet()).size
    }
}
