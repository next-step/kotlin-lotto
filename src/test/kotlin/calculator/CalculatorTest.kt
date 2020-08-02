package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @DisplayName(value = "공백이 입력되면 0을 반환한다.")
    @Test
    fun `when input value is blank then return 0`() {
        assertThat(calculator.add("")).isEqualTo(0)
    }

    @DisplayName(value = "숫자 하나만 입력할 경우 해당 숫자를 반환한다.")
    @Test
    fun `when number is entered as a string then return the number`() {
        assertThat(calculator.add("3")).isEqualTo(3)
    }
}
