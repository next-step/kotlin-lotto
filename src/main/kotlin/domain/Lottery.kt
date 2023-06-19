package domain

import util.NumberGenerator
import util.RandomNumberGenerator

class Lottery(numberGenerator: NumberGenerator = RandomNumberGenerator) {

    val lotteryNumbers = numberGenerator.randomNumbers()

    fun calculatePrize(winningNums: Set<Int>, bonusBall: Int = -1): Prize? {
        val matchedNumberCount = lotteryNumbers.intersect(winningNums).size

        if (matchedNumberCount == Prize.SECOND_PLACE.matches) {
            val extendedWinningNumbers = winningNums.toMutableSet().apply { add(bonusBall) }
            return if (lotteryNumbers.intersect(extendedWinningNumbers).size == Prize.FIRST_PLACE.matches) {
                Prize.SECOND_PLACE
            } else {
                Prize.THIRD_PLACE
            }
        }

        return Prize.getsPrizeFromMatches(matchedNumberCount)
    }
}
