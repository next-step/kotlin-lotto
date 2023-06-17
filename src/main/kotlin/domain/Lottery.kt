package domain

import util.NumberGenerator
import util.RandomNumberGenerator

class Lottery(numberGenerator: NumberGenerator = RandomNumberGenerator) {

    val randomNumbers = numberGenerator.randomNumbers()

    fun getPrizeByLottery(winningNums: Set<Int>, bonusNum: Int = -1): Prize? {
        val matchNumberSize = randomNumbers.intersect(winningNums).size
        if (matchNumberSize == SECOND_THIRD_PLACE) {
            val copiedList = winningNums.toMutableList()
            copiedList.add(bonusNum)
            return if (randomNumbers.intersect(copiedList.toSet()).size == SECOND_PLACE_MATCH) {
                Prize.SECOND_PLACE
            } else {
                Prize.THIRD_PLACE
            }
        }

        return Prize.getsPrizeFromMatches(matchNumberSize)
    }

    companion object {
        private const val SECOND_THIRD_PLACE = 5
        private const val SECOND_PLACE_MATCH = 6
    }
}
