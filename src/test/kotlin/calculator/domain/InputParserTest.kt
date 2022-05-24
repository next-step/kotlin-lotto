package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputParserTest {
    @Test
    fun `쉼표 또는 콜론을 기준으로 구분한다`() {
        val input = "1,3:5"
        val parsed = InputParser.parse(input)

        assertThat(parsed[0]).isEqualTo("1")
        assertThat(parsed[1]).isEqualTo("3")
        assertThat(parsed[2]).isEqualTo("5")
    }

    @Test
    fun `커스텀 구분자를 설정할 수 있다`() {
        val input = "//;\n1;2;3"
        val tokens = InputParser.parse(input)

        assertThat(tokens[0]).isEqualTo("1")
        assertThat(tokens[1]).isEqualTo("2")
        assertThat(tokens[2]).isEqualTo("3")
    }
}
