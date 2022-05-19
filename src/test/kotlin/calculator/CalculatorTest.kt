package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환`(text: String?) {
        val result = Calculator.execute(text)
        assertThat(result).isEqualTo("0")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "5", "9"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환`(text: String) {
        val result = Calculator.execute(text)
        assertThat(result).isEqualTo(text)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2:3", "4,5:9", "9,9:18"], delimiter = ':')
    fun `숫자 두개를 쉼표 구분자로 입력할 경우 두 숫자의 합을 반환`(input: String, output: String) {
        val result = Calculator.execute(input)
        assertThat(result).isEqualTo(output)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2:3[6", "4,5:7[16", "1,5:2[8"], delimiter = '[')
    internal fun `구분자를 쉼표 이외에 콜론을 사용`(input: String, output: String) {
        val result = Calculator.execute(input)
        assertThat(result).isEqualTo(output)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `커스텀 구분자를 지정`(input: String) {
        val result = Calculator.execute(input)
        assertThat(result).isEqualTo("6")
    }

    @ParameterizedTest
    @ValueSource(strings = ["-6", "1,4,-5", "1:4,-6", "//[\n-2[4[6"])
    fun `음수를 전달하는 경우 RuntimeException 예외 처리`(input: String) {
        assertThrows<RuntimeException> { Calculator.execute(input) }
    }
}
