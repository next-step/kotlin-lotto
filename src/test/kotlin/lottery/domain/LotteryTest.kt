package lottery.domain

import fixture.LotteryFixture.TEST_LOTTERY_NUMBERS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LotteryTest {
    @Test
    fun `로또는 로또번호들을 가진다`() {
        val lottery = Lottery(TEST_LOTTERY_NUMBERS)

        assertThat(lottery).isNotNull
    }

    @ParameterizedTest
    @CsvSource("45, true", "30, true", "10, false")
    fun `로또번호에 보너스 볼이 포함되는지 검사한다`(number: Int, expected: Boolean) {
        val bonusBall = BonusBall(number)
        val lotteryNumbers = LotteryNumbers(listOf(20, 30, 25, 9, 40, 45))

        val isContains = Lottery(lotteryNumbers).hasBonusBall(bonusBall)

        assertThat(isContains).isEqualTo(expected)
    }
}
