package stringAddCalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringSeparatorTest {
    @ValueSource(strings = ["1,2:3", "1: 2,  3"])
    @ParameterizedTest
    fun `기본 구분자가 제공될 경우 정상적으로 토큰화되는지 확인`(value: String) { // given
        // when
        val tokens = StringSeparator.separate(value)
        // then
        assertThat(tokens.values).containsExactly(
            Token(1),
            Token(2),
            Token(3)
        )
    }

    @ValueSource(strings = ["//;\n1;2;3", "///\n1/2/3"])
    @ParameterizedTest
    fun `커스텀 구분자가 제공될 경우 정상적으로 토큰화되는지 확인`(value: String) { // given
        // when
        val tokens = StringSeparator.separate(value)
        // then
        assertThat(tokens.values).containsExactly(
            Token(1),
            Token(2),
            Token(3)
        )
    }
}
