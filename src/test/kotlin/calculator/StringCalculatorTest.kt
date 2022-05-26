package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `숫자의 합을 구한다`() {
        assertThat(StringCalculator.calculate("1;2;3")).isEqualTo(6)
    }

    @Test
    fun `null이 오면 0을 반환한다`() {
        assertThat(StringCalculator.calculate(null)).isEqualTo(0)
    }

    @Test
    fun `비어있는 문자열이 0을 반환한다`() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0)
    }
}
