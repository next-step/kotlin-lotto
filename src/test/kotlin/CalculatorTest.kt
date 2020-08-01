import calculator.Calculator
import calculator.CalculatorException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorTest {
    @Test
    fun `모든 숫자값을 합`() {
        val calculator = Calculator("1,2:3")
        assertThat(calculator.execute()).isEqualTo(6)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값 null 및 empty 체크`() {
        val calculator = Calculator(null)
        assertThatThrownBy { calculator.execute() }.isInstanceOf(KotlinNullPointerException::class.java)
    }

    @Test
    fun `숫자, 구분자 이외의 값이 입력되었는지 확인`() {
        val calculator = Calculator("a")
        assertThatThrownBy {
            calculator.execute()
        }.isInstanceOf(CalculatorException::class.java)
    }

    @Test
    fun `문자열 끝이 숫자인`() {
        val calculator = Calculator("1,2,3,")
        assertThatThrownBy {
            calculator.execute()
        }.isInstanceOf(CalculatorException::class.java)
    }

    @Test
    fun `파싱`() {
        val calculator = Calculator("""//;\n1;2;3""")
        assertThat(calculator.execute()).isEqualTo(6)
    }
}
