package calculator

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositiveNumberTest {

    @DisplayName(value = "음수가 주어지면 RuntimeException 예외 처리를 한다")
    @ParameterizedTest
    @ValueSource(ints = [-1])
    fun notPositiveNumber(number: Int) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { PositiveNumber(number) }
    }

    @DisplayName(value = "음수인 문자열이 주어지면 RuntimeException 예외 처리를 한다")
    @ParameterizedTest
    @ValueSource(strings = ["-1"])
    fun notPositiveNumberString(numberString: String) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { PositiveNumber.of(numberString) }
    }

    @DisplayName(value = "숫자가 아닌 문자열이 주어지면 RuntimeException 예외 처리를 한다")
    @ParameterizedTest
    @ValueSource(strings = ["a", ""])
    fun notNumber(text: String) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { PositiveNumber.of(text) }
    }

    @DisplayName(value = "0 또는 양수의 문자열을 양의 정수로 변환할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = ["0", "1"])
    fun positiveNumberString(text: String) {
        PositiveNumber.of(text).value shouldBe text.toInt()
    }

    @DisplayName(value = "0 또는 양수를 양의 정수로 변환할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = [0, 1])
    fun positiveNumber(number: Int) {
        PositiveNumber(number).value shouldBe number
    }
}
