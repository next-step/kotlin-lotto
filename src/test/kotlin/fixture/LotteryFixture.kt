package fixture

import domain.LotteryNumbers
import domain.MockNumbers
import java.util.*

object LotteryFixture {
    private val TEST_MOCK_NUMBERS = listOf(1, 3, 5, 6, 2, 8)
    val TEST_MOCK_LOTTERY = LotteryNumbers.of(MockNumbers(LinkedList(TEST_MOCK_NUMBERS)))
}
