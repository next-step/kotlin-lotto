package stringsumcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["=0", "1=1", "1,2=3", "1,2,3=6", "1,2:3=6"], delimiter = '=')
    fun `쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리`(value: String?, result: Int) {
        val sumValue = if (!value.isNullOrBlank()) {
            Calculator().sum(value, ",|:")
        } else 0
        assertThat(sumValue).isEqualTo(result)
    }

    @Test
    fun `문자를 커스텀 구분자로`() {
        val text = "//;\n1;2;3"
        val result = Calculator().getDestructured(text)?.let {
            Calculator().sum(it.component2(), it.component1())
        }
        assertThat(result).isEqualTo(6)
    }

    @ValueSource(strings = ["//;\n1;2;-3", "1,2,a"])
    @ParameterizedTest
    fun `문자열 계산기에 숫자 이외의 값 또는 음수를 전달`(value: String) {
        assertThrows(RuntimeException::class.java) { Calculator().execute(value) }
    }
}