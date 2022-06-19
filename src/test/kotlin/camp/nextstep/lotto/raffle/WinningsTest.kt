package camp.nextstep.lotto.raffle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningsTest {

    @DisplayName("6개 숫자가 일치하면 상금이 2,000,000,000원이다.")
    @Test
    fun matchedSixNumbers() {
        assertThat(Winnings.of(6).winnings).isEqualTo(2_000_000_000)
    }

    @DisplayName("5개 숫자가 일치하고, 보너스 번호를 맞추면 상금이 30,000,000원이다.")
    @Test
    fun matchedFiveNumbersWithBonus() {
        assertThat(Winnings.of(5, matchedBonus = true).winnings).isEqualTo(30_000_000)
    }

    @DisplayName("5개 숫자가 일치하면 상금이 1,500,000원이다.")
    @Test
    fun matchedFiveNumbers() {
        assertThat(Winnings.of(5).winnings).isEqualTo(1_500_000)
    }

    @DisplayName("4개 숫자가 일치하면 상금이 50,000원이다.")
    @Test
    fun matchedFourNumbers() {
        assertThat(Winnings.of(4).winnings).isEqualTo(50_000)
    }

    @DisplayName("3개 숫자가 일치하면 상금이 5,000원이다.")
    @Test
    fun matchedThreeNumbers() {
        assertThat(Winnings.of(3).winnings).isEqualTo(5_000)
    }
}
