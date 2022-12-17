package lotto.domain.policy

import lotto.domain.vo.LotteryNumber
import lotto.domain.vo.LotteryNumbers
import kotlin.random.Random

sealed interface LotteryNumbersGenerateStrategy {
    fun generate(): LotteryNumbers
}

object LotteryNumberAutoGenerateStrategy : LotteryNumbersGenerateStrategy {

    override fun generate(): LotteryNumbers {
        val lotteryNumbers = mutableSetOf<LotteryNumber>()
        while (lotteryNumbers.size < LotteryNumbers.LOTTERY_NUMBER_SIZE) { lotteryNumbers.add(generateRandomNumber()) }
        return LotteryNumbers(lotteryNumbers = lotteryNumbers.toSet())
    }

    private fun generateRandomNumber(): LotteryNumber {
        val randomValue = Random.nextInt(LotteryNumber.MIN_NUMBER, LotteryNumber.MAX_NUMBER)
        return LotteryNumber(value = randomValue)
    }
}
