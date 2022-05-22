package calculator

import calculator.exception.NegativeNumericException
import calculator.exception.NotNumericException
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2:3=6",
            "1,2,3=6",
            "1:2:3=6",
            "1,2:3,4:5:6:7,8:9,10=55",
            "//;₩n1;2;3=6",
            "//;₩n1;2;3,4:5=15",
            "//#₩n1,2:3#4:5:6#7#8,9:10=55"
        ],
        delimiter = '='
    )
    fun `정상적인 수식 입력 시 성공`(input: String, output: String) {
        assertThat(StringAddCalculator.calculate(input)).isEqualTo(output.toInt())
    }

    @Test
    fun `정상적인 numerics 입력 시 add 연산 성공`() {
        val numerics = listOf("1", "2", "3", "4", "5")
        val addCalculateMethod = StringAddCalculator.javaClass.getDeclaredMethod("addCalculate", List::class.java)
        addCalculateMethod.isAccessible = true
        assertThat(addCalculateMethod.invoke(StringAddCalculator, numerics)).isEqualTo(15)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1+2+3", "1+A+3", "1,2*3", "1!2!3", "//#₩n1,2:3#4:5+6#7#8,9:10"])
    fun `비 정상적인 수식 입력 시 실패`(input: String) {
        Assertions.assertThatThrownBy { StringAddCalculator.calculate(input) }
            .isInstanceOf(NotNumericException::class.java)
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["\n", " ", "   ", "\t"])
    fun `공백 입력시 0으로 변환`(input: String) {
        val getNumericMethod = StringAddCalculator.javaClass.getDeclaredMethod("getNumeric", String::class.java)
        getNumericMethod.isAccessible = true
        assertThat(getNumericMethod.invoke(StringAddCalculator, input)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1])
    fun `음수 입력시 NegativeNumericException 발생`(input: Int) {
        Assertions.assertThatThrownBy { StringAddCalculator.validateNegativeNumeric(input) }
            .isInstanceOf(NegativeNumericException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a"])
    fun `숫자가 아닌 문자 입력시 NotNumericException 발생`(input: String) {
        Assertions.assertThatThrownBy { StringAddCalculator.validateNumeric(input) }
            .isInstanceOf(NotNumericException::class.java)
    }
}
