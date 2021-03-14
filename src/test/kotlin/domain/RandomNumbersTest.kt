package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RandomNumbersTest {

    @Test
    fun `6개의 랜덤 값을 생성한다`() {
        val randomNumber = RandomNumbers()

        val randoms = randomNumber.makeNumbers(1, 45, 6)

        assertAll(
            { assertThat(randoms.size).isEqualTo(6) },
            { assertThat(randoms[0]).isGreaterThan(1) },
            { assertThat(randoms[0]).isLessThan(45) }
        )
    }
}
