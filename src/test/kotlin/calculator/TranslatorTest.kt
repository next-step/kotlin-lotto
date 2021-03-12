package calculator

import calculator.domain.Translator
import calculator.vo.DEFAULT_TOKEN_VALUE
import calculator.vo.Token
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class TranslatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1,2:3", "1:2:3", "1:2,3"])
    internal fun `기본 입력 테스트`(input: String) {
        assertThat(Translator.run(input).tokens)
            .contains(Token(1), Token(2), Token(3))
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    internal fun `커스텀 구분자 입력 테스트`(input: String) {
        assertThat(Translator.run(input).tokens)
            .contains(Token(1), Token(2), Token(3))
    }

    @ParameterizedTest
    @NullAndEmptySource
    internal fun `null or blank 입력 테스트`(input: String?) {
        assertThat(Translator.run(input).tokens)
            .contains(Token(DEFAULT_TOKEN_VALUE))
    }
}
