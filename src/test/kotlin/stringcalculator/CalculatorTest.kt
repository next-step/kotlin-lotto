package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource("1,1", "2,2", "5,5")
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(str: String, expected: Int) {
        val number = str.toIntOrNull()
        assertThat(number).isEqualTo(expected)
    }

    @Test
    fun `입력값이 없을 경우 0 반환`() {
        val calculator = Calculator("")
        val result = calculator.addByDelimiter()
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `콤마 를 기준으로 문자열 덧셈`() {
        val calculator = Calculator("1,2:3")
        val result = calculator.addByDelimiter()
        assertThat(result).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:$", "1,2,-1", """//;\n1;2;-1""", """//;\n1;2;*"""])
    fun `숫자가 아닌 문자 입력 시 예외 발생`(input: String) {
        assertThrows<RuntimeException> {
            val calculator = Calculator(input)
            calculator.addByDelimiter()
        }
    }

    @Test
    fun `커스텀 정규식 테스트`() {
        val result = Regex("//(.)\n(.*)").find("""//;\n1;2;3""")
        result?.let {
            val customDelimiter = it.groupValues[1]
            assertThat(customDelimiter).isEqualTo(";")
            val tokens = it.groupValues[2].split(customDelimiter)
            assertThat(tokens).isEqualTo(listOf("1", "2", "3"))
        }
    }

    @Test
    fun `커스텀 문자열 계산기 테스트`() {
        val calculator = Calculator("""//*\n1*5*9""")
        val result = calculator.addByDelimiter()
        assertThat(result).isEqualTo(15)
    }
}
