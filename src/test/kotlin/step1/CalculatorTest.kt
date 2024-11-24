package step1

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `쉼표 또는 콜론을 구분자로 가지는 문자열을 받는다`() {
        val calculator = Calculator("1,2")

        val sum = calculator.sum()

        assertThat(sum).isEqualTo(3)
    }
}
