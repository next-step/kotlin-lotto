package calculator.domain

import calculator.vo.Token
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TranslatorTest {

    @ParameterizedTest
    @DisplayName("입력에 커스텀 구분자가 없을 때, 기본 구분자로 입력을 분리한다")
    @ValueSource(strings = ["1,2,3", "1,2:3", "1:2:3", "1:2,3"])
    internal fun defaultDelimiterTest(input: String) {
        assertThat(Translator().translate(input).tokens)
            .containsExactly(Token(1), Token(2), Token(3))
    }

    @ParameterizedTest
    @DisplayName("입력에 커스텀 구분자가 있을 때, 커스텀 구분자로 입력을 분리한다")
    @ValueSource(strings = ["//;\n1;2;3"])
    internal fun customDelimiterTest(input: String) {
        assertThat(Translator().translate(input).tokens)
            .contains(Token(1), Token(2), Token(3))
    }

    @ParameterizedTest
    @DisplayName("입력에 커스텀 구분자가 있을 때, 기본 구분자와 동시에 사용은 불가능하다")
    @ValueSource(strings = ["//;\n1;2,3", "//;\n1;2:3"])
    internal fun notAllowedMixedDelimiterTest(input: String) {
        assertThrows<RuntimeException> {
            Translator().translate(input).tokens
        }
    }
}
