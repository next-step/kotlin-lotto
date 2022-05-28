package camp.nextstep.lotto.raffle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningsTest {

    @DisplayName("6개 숫자가 일치하면 상금이 2,000,000,000원이다.")
    @Test
    fun matchedSixNumbersWinningsTest() {
        assertEquals(2_000_000_000, Winnings.of(6).winnings)
    }

    @DisplayName("5개 숫자가 일치하면 상금이 1,500,000원이다.")
    @Test
    fun matchedFiveNumbersWinningsTest() {
        assertEquals(1_500_000, Winnings.of(5).winnings)
    }

    @DisplayName("4개 숫자가 일치하면 상금이 50,000원이다.")
    @Test
    fun matchedFourNumbersWinningsTest() {
        assertEquals(50_000, Winnings.of(4).winnings)
    }

    @DisplayName("3개 숫자가 일치하면 상금이 5,000원이다.")
    @Test
    fun matchedThreeNumbersWinningsTest() {
        assertEquals(5_000, Winnings.of(3).winnings)
    }
}
