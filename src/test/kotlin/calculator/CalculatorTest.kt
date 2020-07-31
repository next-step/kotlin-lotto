package calculator

import Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun `빈 문자열 입력`() {
        assertThat(calculator.calculate("")).isEqualTo(0)
    }
}
