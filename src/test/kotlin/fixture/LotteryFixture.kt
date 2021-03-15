package fixture

import domain.LotteryNumbers

object LotteryFixture {
    private val TEST_NUMBERS = listOf(1, 3, 5, 6, 2, 8)
    val TEST_LOTTERY_NUMBERS = LotteryNumbers(TEST_NUMBERS)
}
