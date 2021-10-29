package domain.calculator.domain.separator

import domain.calculator.strategy.CustomSeparatorRegexStrategy
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SeparatorsTest {

    @Test
    fun `빈 컬렉션이 들어오면 예외를 발생한다`() {
        assertThatThrownBy { Separators.of(setOf()) }
            .isExactlyInstanceOf(RuntimeException::class.java)
            .hasMessage("Separators, 비어있는 컬렉션은 입력될 수 없습니다.")
    }

    @ParameterizedTest(name = "연산식: {0}")
    @ValueSource(strings = ["1", "1,2", "1:2", "1,2:3"])
    fun `커스텀 구분자가 없는 문자열이 있으면 기본 구분자만 가진 객체를 생성한다`(expression: String) {
        val expected = Separators.of(setOf(Separator(","), Separator(":")))
        val actual = Separators.of(expression, CustomSeparatorRegexStrategy)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "연산식: {0}")
    @ValueSource(strings = ["//;\n1", "//;\n1;2", "//;\n1,2:3", "//;\n1;2;3"])
    fun `커스텀 구분자가 있는 문자열이 있으면 커스텀 구분자만 가진 객체를 생성한다`(expression: String) {
        val expected = Separators.of(setOf(Separator(";")))
        val actual = Separators.of(expression, CustomSeparatorRegexStrategy)
        assertThat(actual).isEqualTo(expected)
    }
}
