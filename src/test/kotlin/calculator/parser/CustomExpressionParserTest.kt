package calculator.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CustomExpressionParserTest {
    private val parser = CustomExpressionParser()

    @Test
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    fun `커스텀 기호 지원 여부를 알 수 있다`() {
        // given
        val expression =
            """//?\n"""

        // when
        // then
        assertThat(parser.support(expression)).isTrue()
    }

    @Test
    fun `커스텀 기호로 식 분할이 가능하다`() {
        // given
        val expression =
            """//?\n1?2?3"""

        // when
        val tokens = parser.parse(expression)

        // then
        assertThat(tokens.containsAll(listOf("1", "2", "3"))).isTrue()
    }
}
