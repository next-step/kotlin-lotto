package string

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 입력 시 0을 반환한다`(input: String?) {
        Assertions.assertThat(Calculator.sum(input)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "12", "9", "999"])
    fun `숫자 하나를 입력할 경우 해당 숫자를 반환한다`(input: String) {
        Assertions.assertThat(Calculator.sum(input)).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2=3", "10,2=12", "10:20=30", "1,2:3=6"], delimiter = '=')
    fun `쉼표(,)와 콜론을 구분자로 덧셈을 할 수 있다`(input: String, expect: Int) {
        Assertions.assertThat(Calculator.sum(input)).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n10;20;30"])
    fun `커스텀 구분자를 통해 덧셈을 할 수 있다`(input: String) {
        Assertions.assertThat(Calculator.sum(input)).isEqualTo(60)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n10;20,30:40"])
    fun `커스텀 구분자와 쉼표(,)와 콜론을 통해 덧셈을 할 수 있다`(input: String) {
        Assertions.assertThat(Calculator.sum(input)).isEqualTo(100)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-3", "-", "+", "1:-3", "-9,0", "3,+"])
    fun `숫자 이외의 값 혹은 음수가 들어오면 RuntimeException 예외가 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            Calculator.sum(input)
        }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessageContaining("음수 혹은 숫자가 아닌 값이 들어왔습니다")
    }
}
