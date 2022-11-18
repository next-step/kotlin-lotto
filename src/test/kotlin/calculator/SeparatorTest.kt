package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SeparatorTest {

    @ValueSource(strings = ["a:b,c"])
    @ParameterizedTest
    fun `기본 구분자로 문자를 분리한다`(expression: String) {
        assertThat(Separator.separate(expression)).isEqualTo(listOf("a", "b", "c"))
    }

    @ValueSource(strings = ["//;\na;b;c"])
    @ParameterizedTest
    fun `커스텀 구분자로 문자를 분리한다`(expression: String) {
        assertThat(Separator.separate(expression)).isEqualTo(listOf("a", "b", "c"))
    }

    @ValueSource(strings = ["//;\na;b,c:d"])
    @ParameterizedTest
    fun `커스텀 구분자를 포함한 문자를 분리한다`(expression: String) {
        assertThat(Separator.separate(expression)).isEqualTo(listOf("a", "b", "c", "d"))
    }
}
