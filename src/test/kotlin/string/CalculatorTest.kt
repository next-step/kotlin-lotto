package string

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 입력 시 0을 반환한다`(input: String?) {
        val calculator = Calculator(input)
        Assertions.assertThat(calculator.sum()).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "12", "9", "999"])
    fun `숫자 하나를 입력할 경우 해당 숫자를 반환한다`(input: String) {
        val calculator = Calculator(input)
        Assertions.assertThat(calculator.sum()).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["-3", "-", "+", "1:-3", "-9,0"])
    fun `숫자 이외의 값 혹은 음수가 들어오면 RuntimeException 예외가 발생한다`(input: String) {
        val calculator = Calculator(input)
        Assertions.assertThatThrownBy {
            calculator.sum()
        }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessageContaining("음수 혹은 숫자가 아닌 값이 들어왔습니다")
    }
}
