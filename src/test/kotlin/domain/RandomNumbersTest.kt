package domain

import fixture.LotteryFixture.MAX_LOTTERY_NUMBER
import fixture.LotteryFixture.MIN_LOTTERY_NUMBER
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class RandomNumbersTest {
    @Test
    fun `6개의 1부터 45이하의 중복되지 않는 랜덤 값을 생성한다`() {
        val randoms = RandomNumbers.generate(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, 6)

        assertAll(
            { assertThat(randoms.size).isEqualTo(6) },
            {
                assertAllRangeOfNumbers(randoms)
            }
        )
    }

    @Test
    fun `입력 개수만큼 로또를 생성한다`() {
        val lotteries = Lotteries.of(5)

        assertThat(lotteries.lotteries).hasSize(5)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, -20])
    fun `입력 개수가 0보다 작은경우 생성되지 않는다`(wrongCount: Int) {
        assertThrows<IllegalArgumentException> {
            Lotteries.of(wrongCount)
        }
    }

    private fun assertAllRangeOfNumbers(randoms: List<Int>) {
        randoms.map {
            assertThat(it).isGreaterThan(MIN_LOTTERY_NUMBER)
            assertThat(it).isLessThan(MAX_LOTTERY_NUMBER)
        }
    }
}
