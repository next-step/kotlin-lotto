package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

class CalculatorTest {

    @Test
    fun `빈 문자열은 0을 반환`() {
        val actual = Calculator(Expression("")).sum()
        assertThat(actual).isEqualTo(0)
    }

    @Test
    fun `숫자만 있는 경우 바로 반환`() {
        val actual = Calculator(Expression("23")).sum()
        assertThat(actual).isEqualTo(23)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3=6", "11:22:33=66", "1,2:3:4,5=15"], delimiter = '=')
    fun `콤마와 콜론으로 구분하여 덧셈`(expression: String, expect: Int) {
        val actual = Calculator(Expression(expression)).sum()
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `커스텀 구분자로 구분하여 덧셈`() {
        val actual = Calculator(Expression("//;\n1;2;3")).sum()
        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `음수일 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Calculator(Expression("1,2,-3"))
        }
    }
}
