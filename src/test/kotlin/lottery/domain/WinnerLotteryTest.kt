package lottery.domain

import fixture.LotteryFixture.TEST_BONUS_BALL
import fixture.LotteryFixture.TEST_NUMBERS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class WinnerLotteryTest {
    @Test
    fun `당첨 번호는 6자리를 입력받아 당첨 로또번호를 생성한다`() {
        val numbers = TEST_NUMBERS

        val winnerLottery = WinnerLottery(numbers, TEST_BONUS_BALL)

        assertThat(winnerLottery.winnerLottery).hasSameClassAs(LotteryNumbers(numbers))
    }

    @Test
    fun `우승자 당첨번호와 일치하는 개수를 확인한다`() {
        val numbers = listOf(1, 3, 5, 6, 2, 8)
        val lotteryNumbers = LotteryNumbers(listOf(1, 8, 20, 14, 9, 40))

        val matchCount = WinnerLottery(numbers, TEST_BONUS_BALL).matchCount(lotteryNumbers)

        assertThat(matchCount).isEqualTo(2)
    }

    @ParameterizedTest
    @CsvSource("1, true", "8, true", "45, false")
    fun `우승자 당첨번호에 보너스볼이 포함되는지 확인한다`(number: Int, expected: Boolean) {
        val hasBonusBall = WinnerLottery(listOf(1, 8, 20, 14, 9, 40), TEST_BONUS_BALL).contains(number)

        assertThat(hasBonusBall).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `보너스 볼은 당첨 번호와 중복되서는 안된다`(bonusBall: Int) {
        assertThrows<IllegalArgumentException> {
            WinnerLottery(listOf(1, 2, 3, 4, 5, 6), BonusBall(bonusBall))
        }
    }
}
