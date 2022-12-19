package lotto.domain.policy

import lotto.domain.vo.LotteryNumber
import lotto.domain.vo.LotteryNumbers
import kotlin.random.Random

sealed interface LotteryNumbersGenerateStrategy {
    fun generate(): LotteryNumbers
}

object LotteryNumberAutoGenerateStrategy : LotteryNumbersGenerateStrategy {

    override fun generate(): LotteryNumbers {
        val lotteryNumbersSet = mutableSetOf<LotteryNumber>()
        while (lotteryNumbersSet.size < LotteryNumbers.LOTTERY_NUMBER_SIZE) { lotteryNumbersSet.add(generateRandomNumber()) }
        val lotteryNumbers = lotteryNumbersSet.toList().sortedBy { it.value }
        return LotteryNumbers(lotteryNumbers = lotteryNumbers)
    }

    private fun generateRandomNumber(): LotteryNumber {
        val randomValue = Random.nextInt(LotteryNumber.MIN_NUMBER, LotteryNumber.MAX_NUMBER)
        return LotteryNumber.LOTTERY_NUMBER_LIST[randomValue]
    }
}
