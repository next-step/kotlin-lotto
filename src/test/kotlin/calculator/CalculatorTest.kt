package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @DisplayName(value = "','나 ':' 구분자가 포함된 알맞은 값을 입력했을 때 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1:2,3", "1:2:3"])
    fun `when correct value is input then return correct result`(input: String) {
        assertThat(calculator.add(input)).isEqualTo(6)
    }

    @DisplayName(value = "커스텀한 구분자가 포함된 알맞은 값을 입력했을 때 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `when correct custom value is input then return correct result`(input: String) {
        assertThat(calculator.add(input)).isEqualTo(6)
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

    @DisplayName(value = "음수를 입력하면 exception이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "1:-2:3", "//;\n-1;2;3"])
    fun `when number is negative then throw runtime exception`(value: String) {
        assertThatThrownBy { calculator.add(value) }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("음수는 입력할 수 없습니다.")
    }
}
