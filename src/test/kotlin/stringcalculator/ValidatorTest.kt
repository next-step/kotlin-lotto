package stringcalculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    @Test
    fun `모든 문자가 0보다 큰 숫자이면 예외를 던지지 않는다`() {
        // given
        val validator = Validator()
        val target = listOf("1", "2", "3")

        // when,then
        validator.ensureAllPositiveNumbers(target)
    }

    @Test
    fun `문자열중 하나라도 0보다 큰 숫자가 아니면 예외를 던진다`() {
        // given
        val validator = Validator()
        val target = listOf("1", "2", "-3")

        // when
        assertThatThrownBy { validator.ensureAllPositiveNumbers(target) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo("0보다 큰 숫자 이여야 한다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `문자가 0보다 큰 숫자 아니면 예외를 던지지 않는다`(value: String) {
        // given
        val validator = Validator()

        // when
        validator.ensurePositiveNumber(value)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-2", "a", "!", " ", ""])
    fun `문자가 0보다 큰 숫자가 아니면 예외를 던진다`(target: String) {
        // given
        val validator = Validator()

        // when
        assertThatThrownBy { validator.ensurePositiveNumber(target) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo("0보다 큰 숫자 이여야 한다.")
    }
}
