package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUP() {
        calculator = Calculator()
    }

    @Test
    fun `빈 문자열이면 0을 반환한다`() {
        val actual = calculator.calculate("")

        assertThat(actual).isEqualTo(0)
    }
    @Test
    fun `null이면 0을 반환한다`() {
        val actual = calculator.calculate(null)

        assertThat(actual).isEqualTo(0)
    }


    @Test
    fun `숫자 하나를 입력할 경우 해당 숫자를 그대로 반환한다`(){
        val actual = calculator.calculate("5")

        assertThat(actual).isEqualTo(5)
    }
}
