package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RandomNumbersTest {

    @Test
    fun `6개의 1부터 45이하의 중복되지 않는 랜덤 값을 생성한다`() {
        val randoms = RandomNumbers.generate(1, 45, 6)

        assertAll(
            { assertThat(randoms.size).isEqualTo(6) },
            {
                assertAllRangeOfNumbers(randoms)
            }
        )
    }

    private fun assertAllRangeOfNumbers(randoms: List<Int>) {
        randoms.map {
            assertThat(it).isGreaterThan(1)
            assertThat(it).isLessThan(45)
        }
    }
}
