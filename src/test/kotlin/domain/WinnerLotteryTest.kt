package domain

import fixture.LotteryFixture.TEST_NUMBERS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

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

    @Test
    fun `로또번호들 중에 당첨번호와 일치하는 개수들을 전달한다`() {
        val lotteries = listOf(
            createLottery(listOf(1, 3, 5, 2, 9, 40)),
            createLottery(listOf(34, 24, 1, 15, 3, 5)),
            createLottery(listOf(3, 1, 5, 15, 24, 40)),
            createLottery(listOf(1, 3, 5, 40, 24, 15))
        )

        val winnerLottery = WinnerLottery(listOf(1, 3, 5, 24, 15, 40))

        val matchCounts = winnerLottery.match(lotteries)

        assertAll(
            { assertThat(matchCounts[4]).isEqualTo(1) },
            { assertThat(matchCounts[5]).isEqualTo(1) },
            { assertThat(matchCounts[6]).isEqualTo(2) }
        )
    }

    private fun createLottery(numbers: List<Int>) = Lottery(LotteryNumbers(numbers))
}
