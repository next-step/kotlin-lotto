package fixture

import domain.LotteryNumbers

object LotteryFixture {
    private val TEST_NUMBERS = listOf(1, 3, 5, 6, 2, 8)
    val TEST_LOTTERY_NUMBERS = LotteryNumbers(TEST_NUMBERS)

    const val MIN_LOTTERY_NUMBER = 1
    const val MAX_LOTTERY_NUMBER = 45
}
