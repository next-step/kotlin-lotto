package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ExpressionTest {

    @DisplayName(value = "문자를 입력하면 식에 포함된 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,5,6"])
    fun extractTokens(text: String) {
        assertThat(Expression(text).extractTokens()).containsExactlyInAnyOrder(
            Token("1"),
            Token("2"),
            Token("5"),
            Token("6")
        )
    }

    @DisplayName(value = "음수를 전달하는 경우 RuntimeException 예외를 발생")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,5,-6"])
    fun validExpression(text: String) {
        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy { Expression(text).extractTokens() }
    }

    @DisplayName(value = "유효하지 않은 문자가 있을 경우 RuntimeException 발생")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,a"])
    fun invalidDelimiter(text: String) {
        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy { Expression(text).extractTokens() }
    }
}
