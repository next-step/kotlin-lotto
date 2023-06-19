package domain

import util.NumberGenerator
import util.RandomNumberGenerator

class Lottery(numberGenerator: NumberGenerator = RandomNumberGenerator) {

    val randomNumbers = numberGenerator.randomNumbers()

    fun getPrizeByLottery(winningNums: Set<Int>, bonusNum: Int = -1): Prize? {
        val matchNumberSize = randomNumbers.intersect(winningNums).size
        if (matchNumberSize == Prize.SECOND_PLACE.matches) {
            val copiedList = winningNums.toMutableList()
            copiedList.add(bonusNum)
            return if (randomNumbers.intersect(copiedList.toSet()).size == Prize.FIRST_PLACE.matches) {
                Prize.SECOND_PLACE
            } else {
                Prize.THIRD_PLACE
            }
        }

        return Prize.getsPrizeFromMatches(matchNumberSize)
    }
}
