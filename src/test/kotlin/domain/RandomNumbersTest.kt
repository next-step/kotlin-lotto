package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RandomNumbersTest {

    @Test
    fun `6개의 랜덤 값을 생성한다`() {
        val randomNumber = RandomNumbers()

        val randoms = randomNumber.makeNumber(0, 45)

        assertAll(
            { assertThat(randoms).isGreaterThan(0) },
            { assertThat(randoms).isLessThan(45) }
        )
    }
}
