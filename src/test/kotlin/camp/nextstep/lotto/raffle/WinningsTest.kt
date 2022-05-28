package camp.nextstep.lotto.raffle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningsTest {

    @DisplayName("6개 숫자가 일치하면 상금이 2,000,000,000원이다.")
    @Test
    fun matchedSixNumbers() {
        assertEquals(2_000_000_000, Winnings.of(6).winnings)
    }

    @DisplayName("5개 숫자가 일치하고, 보너스 번호를 맞추면 상금이 30,000,000원이다.")
    @Test
    fun matchedFiveNumbersWithBonus() {
        assertEquals(30_000_000, Winnings.of(5, matchedBonus = true).winnings)
    }

    @DisplayName("5개 숫자가 일치하면 상금이 1,500,000원이다.")
    @Test
    fun matchedFiveNumbers() {
        assertEquals(1_500_000, Winnings.of(5).winnings)
    }

    @DisplayName("4개 숫자가 일치하면 상금이 50,000원이다.")
    @Test
    fun matchedFourNumbers() {
        assertEquals(50_000, Winnings.of(4).winnings)
    }

    @DisplayName("3개 숫자가 일치하면 상금이 5,000원이다.")
    @Test
    fun matchedThreeNumbers() {
        assertEquals(5_000, Winnings.of(3).winnings)
    }
}
