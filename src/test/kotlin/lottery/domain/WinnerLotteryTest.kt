package lottery.domain

import fixture.LotteryFixture.TEST_NUMBERS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerLotteryTest {
    @Test
    fun `당첨 번호는 6자리를 입력받아 당첨 로또번호를 생성한다`() {
        val numbers = TEST_NUMBERS

        val winnerLottery = WinnerLottery(numbers)

        assertThat(winnerLottery.winnerLottery).hasSameClassAs(LotteryNumbers(numbers))
    }

    @Test
    fun `우승자 당첨번호와 일치하는 개수를 확인한다`() {
        val numbers = listOf(1, 3, 5, 6, 2, 8)
        val lotteryNumbers = LotteryNumbers(listOf(1, 8, 20, 14, 9, 40))

        val matchCount = WinnerLottery(numbers).matchCount(lotteryNumbers)

        assertThat(matchCount).isEqualTo(2)
    }
}
