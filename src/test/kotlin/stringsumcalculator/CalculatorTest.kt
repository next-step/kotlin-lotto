package stringsumcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest
    @CsvSource(value = ["=0", "1=1", "1,2=3", "1,2,3=6", "1,2:3=6"], delimiter = '=')
    fun `쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리`(value: String?, result: Int) {
        val sumValue = if (!value.isNullOrBlank()) {
            calculator.sum(value, ",|:")
        } else 0
        assertThat(sumValue).isEqualTo(result)
    }

    @Test
    fun `문자를 커스텀 구분자로 사용해서 계산`() {
        val text = "//;\n1;2;3"
        val result = calculator.execute(text)
        assertThat(result).isEqualTo(6)
    }

    @ValueSource(strings = ["//;\n1;2;-3", "1,2,a"])
    @ParameterizedTest
    fun `문자열 계산기에 숫자 이외의 값 또는 음수를 전달 후 RuntimeException`(value: String) {
        assertThrows<RuntimeException> { calculator.execute(value) }
    }
}