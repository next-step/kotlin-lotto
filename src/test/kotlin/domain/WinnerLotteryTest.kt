package domain

import fixture.LotteryFixture.TEST_NUMBERS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerLotteryTest {
    @Test
    fun `당첨 번호는 6자리를 입력받아 당첨 로또번호를 생성한다`() {
        val numbers = TEST_NUMBERS

        val winnerLottery = WinnerLottery(numbers)

        assertThat(winnerLottery.numbers).hasSameClassAs(LotteryNumbers(numbers))
    }

    @Test
    fun `로또번호와 당첨번호의 일치하는 개수를 구한다`() {
        val lotteryNumbers = LotteryNumbers(TEST_NUMBERS)

        val winnerLottery = WinnerLottery(listOf(1, 3, 5, 24, 15, 40))

        val count = winnerLottery.matchCount(lotteryNumbers)

        assertThat(count).isEqualTo(3)
    }
}
