package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1:2:3"])
    fun `정해진 구분자로 숫자 string이 오면 모든 숫자를 더한다`(input: String) {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate(input)).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//;%\n1;2%3"])
    fun `정해진 문자 사이에 문자를 지정하면 그 문자도 구분자에 추가한다`(input: String) {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate(input)).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,2,3", "//;\n-1,2,3"])
    fun `문자열의 음수가 오는 경우 예외를 던진다`(input: String) {
        val stringCalculator = StringCalculator()
        assertThatThrownBy { stringCalculator.calculate(input) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("음수가 입력으로 들어왔어요")
    }

    @Test
    fun `문자열의 숫자 자리가 문자가 오면 예외를 던진다`() {
        val stringCalculator = StringCalculator()
        assertThatThrownBy { stringCalculator.calculate("*,2,3") }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 아니에요")
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열이나 null을 입력하면 0을 출력한다`(input: String?) {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate(input)).isEqualTo(0)
    }
}
