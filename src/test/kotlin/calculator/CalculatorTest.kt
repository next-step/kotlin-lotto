package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈칸 또는 null이 입력될 경우 0이 반환 된다")
    fun `빈칸 또는 null이 입력될 경우 0이 반환 된다`(input: String?) {
        val actual = Calculator.add(input)
        val expected = 0
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    @DisplayName("숫자가 하나만 입력될 경우 해당 숫자가 반환 된다")
    fun `숫자가 하나만 입력될 경우 해당 숫자가 반환 된다`(input: String) {
        val actual = Calculator.add(input)
        val expected = input.toInt()
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3| 6", "1,2:4| 7", "1:2:7| 10"], delimiter = '|')
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 한다")
    fun `쉼표 또는 콜른 구분자를 기준으로 분리한 각 숫자의 합을 반환 한다`(input: String, expected: Int) {
        val actual = Calculator.add(input)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//g\n1g2g3"])
    @DisplayName("//와 \\n 사이에 커스텀 구분자를 지정 할 수 있다.")
    fun `커스텀 구분자를 지정 할 수 있다`(input: String) {
        val actual = Calculator.add(input)
        val expected = 6
        assertThat(actual).isEqualTo(expected)
    }
}
