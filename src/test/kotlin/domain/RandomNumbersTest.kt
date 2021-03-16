package domain

import fixture.LotteryFixture.LOTTERY_NUMBERS_SIZE
import fixture.LotteryFixture.MAX_LOTTERY_NUMBER
import fixture.LotteryFixture.MIN_LOTTERY_NUMBER
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RandomNumbersTest {
    @Test
    fun `6개의 1부터 45이하의 중복되지 않는 랜덤 값을 생성한다`() {
        val randoms = RandomNumbers.generate(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, LOTTERY_NUMBERS_SIZE)

        assertAll(
            { assertThat(randoms.size).isEqualTo(6) },
            {
                assertAllRangeOfNumbers(randoms)
            }
        )
    }

    private fun assertAllRangeOfNumbers(randoms: List<Int>) {
        randoms.map {
            assertThat(it).isGreaterThan(MIN_LOTTERY_NUMBER)
            assertThat(it).isLessThanOrEqualTo(MAX_LOTTERY_NUMBER)
        }
    }
}
