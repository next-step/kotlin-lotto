package stringcalculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `문자가 0보다 큰 숫자 아니면 예외를 던지지 않는다`(value: String) {
        // given
        val stringCalculatorNumberValidator = StringCalculatorNumberValidator()

        // when
        stringCalculatorNumberValidator.ensurePositiveNumber(value)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-2", "a", "!", " ", ""])
    fun `문자가 0보다 큰 숫자가 아니면 예외를 던진다`(target: String) {
        // given
        val stringCalculatorNumberValidator = StringCalculatorNumberValidator()

        // when
        assertThatThrownBy { stringCalculatorNumberValidator.ensurePositiveNumber(target) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo("0보다 큰 숫자 이여야 한다.")
    }
}
