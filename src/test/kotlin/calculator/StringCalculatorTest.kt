package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {

    @Test
    fun `숫자의 합을 구한다`() {
        val numbers = listOf("1", "2", "3")
        assertThat(StringCalculator().calculate(numbers)).isEqualTo(6)
    }

    @Test
    fun `음수의 값이 들어오면 RuntimeException 가 발생한다`() {
        val numbers = listOf("-1", "-2", "4")
        assertThrows<RuntimeException> {
            StringCalculator().calculate(numbers)
        }
    }

    @Test
    fun `숫자가 아닌 값이 들어오면 RuntimeException 가 발생한다`() {
        val numbers = listOf("a", "b", "c")
        assertThrows<RuntimeException> {
            StringCalculator().calculate(numbers)
        }
    }
}
