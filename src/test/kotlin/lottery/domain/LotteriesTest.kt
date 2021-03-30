package lottery.domain

import fixture.LotteryFixture.TEST_LOTTERY_NUMBERS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LotteriesTest {
    @Test
    fun `입력 개수만큼 로또를 생성한다`() {
        val allNumbers = Numbers(
            listOf(
                TEST_LOTTERY_NUMBERS,
                TEST_LOTTERY_NUMBERS,
                TEST_LOTTERY_NUMBERS,
                TEST_LOTTERY_NUMBERS,
                TEST_LOTTERY_NUMBERS
            )
        )

        val lotteries = Lotteries.of(allNumbers)

        assertThat(lotteries.lotteries).containsExactly(
            Lottery(TEST_LOTTERY_NUMBERS),
            Lottery(TEST_LOTTERY_NUMBERS),
            Lottery(TEST_LOTTERY_NUMBERS),
            Lottery(TEST_LOTTERY_NUMBERS),
            Lottery(TEST_LOTTERY_NUMBERS)
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, -20])
    fun `입력 개수가 0보다 작은경우 생성되지 않는다`(wrongCount: Int) {
        val allNumbers = Numbers((1..wrongCount).map { TEST_LOTTERY_NUMBERS })

        assertThrows<IllegalArgumentException> {
            Lotteries.of(allNumbers)
        }
    }
}
