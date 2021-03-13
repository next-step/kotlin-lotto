package fixture

import domain.LotteryNumbers
import domain.MockNumbers

object LotteryFixture {
    private val TEST_MOCK_NUMBERS = MockNumbers(hashSetOf(1, 3, 5, 6, 2, 8))
    val TEST_MOCK_LOTTERY = LotteryNumbers(TEST_MOCK_NUMBERS)
}
