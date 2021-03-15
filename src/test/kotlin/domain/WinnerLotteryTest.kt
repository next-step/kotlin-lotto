package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerLotteryTest {
    @Test
    fun `당첨 번호는 6자리를 입력받아 당첨 로또번호를 생성한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        val winnerLottery = WinnerLottery(numbers)

        assertThat(winnerLottery.numbers).hasSameClassAs(LotteryNumbers(numbers))
    }
}
