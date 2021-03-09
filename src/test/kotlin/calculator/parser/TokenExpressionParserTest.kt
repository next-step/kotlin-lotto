package calculator.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TokenExpressionParserTest {

    @Test
    fun `분할가능한 식인지 확인한다`() {
        // given
        val parser = TokenExpressionParser("#", "?")
        val expression = "1.2;3"

        // when
        // then
        assertThat(parser.support(expression)).isFalse()
    }

    @Test
    fun `원하는 토큰으로 식 분할이 가능하다`() {
        // given
        val parser = TokenExpressionParser("|", "?")
        val expression = "1|2?3"

        // when
        val result = parser.parse(expression)

        // then
        assertThat(result.containsAll(listOf("1", "2", "3"))).isTrue()
    }
}
