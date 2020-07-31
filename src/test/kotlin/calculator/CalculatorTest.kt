package calculator

import Calculator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @Test
    fun `하나의 숫자 입력`() {
        assertThat(calculator.calculate("3")).isEqualTo(3)
    }

    @Test
    fun `쉼표가 포함된 문자열 입력`() {
        assertThat(calculator.calculate("1,2,3")).isEqualTo(6)
    }

    @Test
    fun `쉼표와 콜론이 포함된 문자열 입력`() {
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6)
    }

    @Test
    fun `커스텀 구분자가 사용된 문자열 입력`() {
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "1,-2,3"])
    fun `음수 입력`(input: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.calculate(input) }
    }
}
