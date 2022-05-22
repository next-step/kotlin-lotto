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
        ],
        delimiter = '='
    )
    fun `정상적인 수식 입력 시 성공`(input: String, output: String) {
        val stringAddCalculator = StringAddCalculator()
        assertThat(stringAddCalculator.calculate(input)).isEqualTo(output.toInt())
    }

    @Test
    fun `정상적인 numerics 입력 시 add 연산 성공`() {
        val stringAddCalculator = StringAddCalculator()
        val numerics = listOf("1", "2", "3", "4", "5")
        assertThat(stringAddCalculator.addCalculate(numerics)).isEqualTo(15)
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = ["\n", " ", "   ", "\t"])
    fun `공백 입력시 0으로 변환`(input: String) {
        val stringAddCalculator = StringAddCalculator()
        assertThat(stringAddCalculator.getNumeric(input)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1])
    fun `음수 입력시 NegativeNumericException 발생`(input: Int) {
        val stringAddCalculator = StringAddCalculator()
        Assertions.assertThatThrownBy { stringAddCalculator.validateNegativeNumeric(input) }
            .isInstanceOf(NegativeNumericException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a"])
    fun `숫자가 아닌 문자 입력시 NotNumericException 발생`(input: String) {
        val stringAddCalculator = StringAddCalculator()
        Assertions.assertThatThrownBy { stringAddCalculator.validateNumeric(input) }
            .isInstanceOf(NotNumericException::class.java)
    }
}
