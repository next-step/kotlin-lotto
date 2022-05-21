package expressioncalculator.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ParseResultTest {
    @Test
    fun `ParseResultSuccess는 분리된 숫자의 리스트를 보관한다`() {
        val success = ParseResult.Success(listOf(1, 2, 3))

        assertThat(success.numbers).isEqualTo(listOf(1, 2, 3))
    }

    @Test
    fun `ParseResultFailed는 parse를 시도했던 문자열을 그대로 보관한다`() {
        val failed = ParseResult.Failed("//;\n1;2;3")

        assertThat(failed.expression).isEqualTo("//;\n1;2;3")
    }
}
