package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ExpressionTest {

    @DisplayName(value = "문자를 입력하면 식에 포함된 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 5, 6"])
    fun extractTokens(text: String) {
        assertThat(Expression(text).extractTokens()).contains("1", "2", "5", "6")
    }
}
