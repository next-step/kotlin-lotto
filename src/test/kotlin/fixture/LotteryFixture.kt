package fixture

import lottery.domain.BonusBall
import lottery.domain.LotteryNumbers
import lottery.domain.MockGenerator

object LotteryFixture {
    val TEST_NUMBERS = listOf(1, 3, 5, 6, 2, 8)
    val TEST_LOTTERY_NUMBERS = LotteryNumbers(TEST_NUMBERS)
    val TEST_GENERATOR = MockGenerator(TEST_NUMBERS)
    val TEST_BONUS_BALL = BonusBall(10)

    const val MIN_LOTTERY_NUMBER = 1
    const val MAX_LOTTERY_NUMBER = 45

    const val LOTTERY_NUMBERS_SIZE = 6
}
