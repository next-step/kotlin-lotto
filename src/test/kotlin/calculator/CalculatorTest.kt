package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @DisplayName("모든 숫자값을 합")
    @Test
    fun `calculate`() {
        val calculator = Calculator("1,2:3")
        assertThat(calculator.execute()).isEqualTo(6)
    }

    @DisplayName("입력값 empty 체크")
    @ParameterizedTest
    @EmptySource
    fun `checkForEmpty`(numberInput: String) {
        val calculator = Calculator(numberInput)
        assertThatThrownBy { calculator.execute() }.isInstanceOf(CalculatorException::class.java)
    }

    @DisplayName("사용자가 입력한 문자열이 규칙에 맞지 않을경우")
    @ParameterizedTest
    @ValueSource(strings = ["a", "&", "1,2,3,", ",1,2,3"])
    fun `hasOnlyValidString`(numberInput: String) {
        val calculator = Calculator(numberInput)
        assertThatThrownBy {
            calculator.execute()
        }.isInstanceOf(CalculatorException::class.java)
    }

    @DisplayName("사용자가 입력한 문자열로 파싱")
    @Test
    fun `execute`() {
        val calculator = Calculator("//;\n1;2;3")
        assertThat(calculator.execute()).isEqualTo(6)
    }
}
