package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `숫자의 합을 구한다`() {
        val numbers = listOf(1, 2, 3)
        assertThat(StringCalculator().calculate(numbers)).isEqualTo(6)
    }
}
