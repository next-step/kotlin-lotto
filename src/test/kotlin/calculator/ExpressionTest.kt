package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ExpressionTest {

    @DisplayName(value = "문자를 입력하면 식에 포함된 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 5, 6"])
    fun extractTokens(text: String) {
        assertThat(Expression(text).extractTokens()).contains("1", "2", "5", "6")
    }

    @DisplayName(value = "양의 정수와 ,로 구성된 식이면 true 반환")
    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 5, 6"])
    fun validExpression(text: String) {
        assertThat(Expression(text).isValid()).isTrue()
    }

    @DisplayName(value = "음수가 포함된 식이면 false 반환")
    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 5, -6"])
    fun negativeNumber(text: String) {
        assertThat(Expression(text).isValid()).isFalse()
    }

    @DisplayName(value = "커스텀 구분자와 식에 포함된 구분자가 일치하지 않을 경우 false 반환")
    @ParameterizedTest
    @ValueSource(strings = ["//;;\n1;2;3;4"])
    fun invalidDelimiter(text: String) {
        assertThat(Expression(text).isValid()).isFalse()
    }
}
